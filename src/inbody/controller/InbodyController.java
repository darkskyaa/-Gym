package inbody.controller;

import inbody.enums.InbodyStatus;
import inbody.pojo.InbodyBean;
import inbody.service.InbodyService;

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
	public ModelMap add(@RequestBody MemberBean member) {
		InbodyStatus status = inbodyService.add(member);
		return getResultMap(status);
	}
	
	@GetMapping("findByMemberId")
	public InbodyBean findByMemberId(Integer memberId) {
		return inbodyService.selectByMemberId(memberId);
	}
	
	@PostMapping("modify")
	public ModelMap update(@RequestBody MemberBean member) {
		InbodyStatus status = inbodyService.update(member);
		return getResultMap(status);
	}
	
	private ModelMap getResultMap(InbodyStatus status) {
		ModelMap resultMap = new ModelMap();
		resultMap.put("code", status.getCode());
		resultMap.put("msg", status);
		return resultMap;
	}
}
