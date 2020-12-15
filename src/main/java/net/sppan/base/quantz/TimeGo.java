package net.sppan.base.quantz;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.sppan.base.dao.IMemberLogDao;
import net.sppan.base.entity.Member;
import net.sppan.base.entity.MemberLog;
import net.sppan.base.service.IMemberLogService;
import net.sppan.base.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Component
public class TimeGo  {

    @Autowired
    private IMemberService memberService;
    @Autowired
    private IMemberLogDao iMemberLogDao;

    /**
     * 上班打卡
     */
    @Scheduled(cron="0 0 8 * * *")
    public void timingTask() {
        doDaKa();
    }


    /**
     * 下班打卡
     */
    @Scheduled(cron="0 0 19 * * *")
    public void timingexit() {
        doDaKa();
    }

    /**
     * 打卡， 随机时间
     */
    public void doDaKa(){
        List<Member> all = memberService.findAll();
        int a = 3600 % all.size() * 700;

        for (Member member : all) {

            MemberLog memberLog = new MemberLog();
            memberLog.setMid(member.getId());
            memberLog.setName(member.getName());
            memberLog.setDatatype("2");
            memberLog.setOpenid(member.getOpenid());


            try {
                StringBuffer str = new StringBuffer();
                Thread.sleep( (int) (Math.random()*(a)+1) );
                String doPost = new ClockSave().doPost(member.getOpenid());
                ResData resData = JSON.parseObject(doPost, ResData.class);

                //假设状态不是成功的， 再此调用该系统, 最多调用三次
                if(!resData.getCode().equals("0")){
                    String doPost1 = new ClockSave().doPost(member.getOpenid());
                    ResData resData1 = JSON.parseObject(doPost1, ResData.class);
                    if(!resData1.getCode().equals("0")){
                        String doPost2 =new ClockSave().doPost(member.getOpenid());
                        ResData resData2 = JSON.parseObject(doPost2, ResData.class);
                        if(!resData2.getCode().equals("0")){
                            throw new Exception("失败：code : " + resData2.getCode() + ", msg" + resData2.getMsg());
                        }else{
                            resData = resData2;
                            doPost = doPost2;
                        }
                    }else{
                        resData = resData1;
                        doPost = doPost1;
                    }

                }


                //返回的状态和信息
                memberLog.setMsg(resData.getMsg());
                memberLog.setStatus(resData.getCode());

                str.append("下班" + member.getName() + doPost + "sueecss");
                Date date = new Date();
                SimpleDateFormat sip = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                str.append(sip.format(date));
                log.info(str.toString());
            }catch (Exception e){
                StringBuffer str = new StringBuffer();
                str.append("下班" + member.getName() + "faulit");
                Date date = new Date();
                SimpleDateFormat sip = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                str.append(sip.format(date));

                //失败
                memberLog.setMsg(e.getMessage());
                memberLog.setStatus("-1");

                log.info(str.toString());
//                memberLog.setStatus("2");
            }
            try{
                memberLog.setInputtime(new Date());
                iMemberLogDao.save(memberLog);
            }catch (Exception e) {
                log.info("存表失败");
            }

        }

    }
}
