package member.controller;

import static util.Constant.STANDARD_DATE_FORMAT;

import java.util.Date;

import javax.servlet.http.HttpSession;

import member.pojo.MemberBean;
import member.service.MemberService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {
	private static Logger logger = Logger.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@GetMapping("findMemberById")
	public MemberBean findMemberById(Integer id) {
		if (id == null) {
			return null;
		}
		return memberService.selectById(id);
	}

	@PostMapping("register")
	public String register(MemberBean member) {
		return memberService.register(member);
	}
	
	@PostMapping("login")
	public String login(HttpSession session, String account, String password) {
		MemberBean member = memberService.login(account, password); 
		if (member != null) {
			session.setAttribute("member", member);
			return "success";
		} else {
			return "failure";
		}
	}

	@GetMapping("t1")
	public String t1() {
		logger.info("member/t1");
		System.out.println("id\tname");
		for (MemberBean member : memberService.getAll()) {
			System.out.println(member.getId() + "\t" + member.getName());
		}
		return "result";
	}
	
	@InitBinder
	void dataBinderInit(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(STANDARD_DATE_FORMAT, true));
	}
}
