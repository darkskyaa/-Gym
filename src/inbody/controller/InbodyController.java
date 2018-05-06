package inbody.controller;

import inbody.enums.InbodyStatus;
import inbody.pojo.InbodyBean;
import inbody.service.InbodyService;

import java.util.HashMap;
import java.util.Map;

import member.pojo.MemberBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inbody")
public class InbodyController {
	@Autowired
	private InbodyService inbodyService;

	@PostMapping("add")
	public Map<String, String> add(@RequestBody MemberBean member) {
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("msg", inbodyService.add(member));
		return resultMap;
	}
	
	@GetMapping("findByMemberId")
	public InbodyBean findByMemberId(Integer memberId) {
		return inbodyService.selectByMemberId(memberId);
	}
	
	@PostMapping("modify")
	public ModelMap update(@RequestBody MemberBean member) {
		InbodyStatus status = inbodyService.update(member);
		ModelMap resultMap = new ModelMap();
		resultMap.put("code", status.getCode());
		resultMap.put("msg", status);
		return resultMap;
	}
}
