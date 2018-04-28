package member.controller;

import static util.Constant.BIRTH_DATE_FORMAT;

import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestBody;
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
	public String register(@RequestBody MemberBean member) {
		member.setBirthday(member.getBirthday().substring(0, 10));
		member.setPoint(0);
		return memberService.register(member);
	}
	
	@PostMapping("login")
	public MemberBean login(@RequestBody MemberBean member) {
		return memberService.login(member.getAccount(), member.getPassword());
	}

	@InitBinder
	void dataBinderInit(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(BIRTH_DATE_FORMAT, true));
	}
}
