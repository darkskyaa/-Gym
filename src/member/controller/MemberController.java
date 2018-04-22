package member.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.pojo.Member;
import member.service.MemberService;

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
	
	@GetMapping("angular")
	public ResponseEntity<List<Member>> t2() {
		logger.info("member/angular");
		System.out.println("angular");
		List<Member> list = new ArrayList<>();
		Member mem = new Member();
		mem.setId(1);
		mem.setName("哪裡來的駱駝客呀");
		list.add(mem);
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
}
