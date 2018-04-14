package member.controller;

import member.pojo.Member;
import member.service.MemberService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	private static Logger logger = Logger.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("t1")
	public String t1() {
		logger.info("member/t1");
		System.out.println("id\tname");
		for (Member member : memberService.getAll()) {
			System.out.println(member.getId() + "\t" + member.getName());
		}
		return "result";
	}
}
