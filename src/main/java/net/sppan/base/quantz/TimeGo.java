package net.sppan.base.quantz;

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
        List<Member> all = memberService.findAll();
        int a = 3600 % all.size() ;

        for (Member member : all) {

            MemberLog memberLog = new MemberLog();
            memberLog.setId(member.getId());
            memberLog.setName(member.getName());


            try {
                StringBuffer str = new StringBuffer();
                Thread.sleep( (int) (Math.random()*(a)+1) );
                String doPost = new ClockSave().doPost(member.getOpenid());

                memberLog.setMsg(doPost);
                memberLog.setStatus("1");

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
                log.info(str.toString());
                memberLog.setStatus("2");
            }
            try{
                memberLog.setInputtime(new Date());
                iMemberLogDao.save(memberLog);
            }catch (Exception e) {
                log.info("存表失败");
            }

        }
    }


    /**
     * 下班打卡
     */
    @Scheduled(cron="0 0 19 * * *")
    public void timingexit() {
        List<Member> all = memberService.findAll();

        int a = 3600 % all.size() ;
        for (Member member : all) {

            MemberLog memberLog = new MemberLog();
            memberLog.setId(member.getId());
            memberLog.setName(member.getName());
            memberLog.setOpenid(member.getOpenid());

            try {
                StringBuffer str = new StringBuffer();
                Thread.sleep( (int) (Math.random()*(a)+1) );
                String doPost = new ClockSave().doPost(member.getOpenid());

                memberLog.setMsg(doPost);
                memberLog.setStatus("1");

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
                log.info(str.toString());
                memberLog.setStatus("2");
            }
            try {
                memberLog.setInputtime(new Date());
                iMemberLogDao.save(memberLog);

            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}
