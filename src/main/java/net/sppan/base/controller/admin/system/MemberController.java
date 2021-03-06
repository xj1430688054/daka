package net.sppan.base.controller.admin.system;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.dao.IMemberLogDao;
import net.sppan.base.entity.Member;
import net.sppan.base.entity.MemberLog;
import net.sppan.base.quantz.ClockSave;
import net.sppan.base.quantz.ResData;
import net.sppan.base.service.IMemberService;
import net.sppan.base.service.specification.SimpleSpecificationBuilder;
import net.sppan.base.service.specification.SpecificationOperator.Operator;
import net.sppan.base.vo.ZtreeView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/admin/member")
public class MemberController extends BaseController {
	@Autowired
	private IMemberService memberService;

	private IMemberLogDao iMemberLogDao;



	@RequestMapping("/index")
	public String index() {
		return "admin/member/index";
	}

//	@ResponseBody
	public String test(@PathVariable Integer id,ModelMap map) {

		ResData resData = new ResData();

		//����־
		MemberLog memberLog = new MemberLog();
		Member member = memberService.find(id);
		memberLog.setOpenid(member.getOpenid());
		memberLog.setInputtime(new Date());
		memberLog.setMid(member.getId());
		memberLog.setName(member.getName());
		memberLog.setDatatype("1");
		StringBuffer str = new StringBuffer();
		try {
			String doPost = new ClockSave().doPost(member.getOpenid());
			resData = JSON.parseObject(doPost, ResData.class);

//			resData.setMsg(doPost);
//			resData.setCode();
			memberLog.setStatus("1");
			str.append(member.getName() + doPost + "sueecss");
			str.append("\r\n");
			log.info(member.getName() + doPost + "sueecss");
		}catch (Exception e){
			resData.setCode("null");
			resData.setMsg(e.getMessage());
			memberLog.setStatus("0");
			str.append(member.getName() + "faulit");
			str.append("\r\n");
			log.info(member.getName() + "faulit");
		}
		map.put("resdata", resData);


//		System.out.println(doPost);
		return "admin/member/test";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Page<Member> list() {
		SimpleSpecificationBuilder<Member> builder = new SimpleSpecificationBuilder<Member>();
		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("name", Operator.likeAll.name(), searchText);
		}
		Page<Member> page = memberService.findAll(builder.generateSpecification(),getPageRequest());
		return page;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		List<Member> list = memberService.findAll();
		map.put("list", list);
		return "admin/member/form";
	}


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		Member member = memberService.find(id);
		map.put("member", member);

		List<Member> list = memberService.findAll();
		map.put("list", list);
		return "admin/member/form";
	}

	@RequestMapping(value= {"/edit"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(Member member,ModelMap map){
		try {
			memberService.saveOrUpdate(member);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			memberService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
