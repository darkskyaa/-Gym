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

/**
 * The controller of Inbody subsystem
 * @date 2018-04-29
 * @category Inbody
 * @author William
 */
@RestController
@RequestMapping("inbody")
public class InbodyController {
	@Autowired
	private InbodyService inbodyService;

	/**
	 * The we api for adding a inbody
	 * @param member : member object with member id and new inbody information
	 * @return result map for adding
	 */
	@PostMapping("add")
	public ModelMap add(@RequestBody MemberBean member) {
		InbodyStatus status = inbodyService.add(member);
		return getResultMap(status);
	}
	
	/**
	 * The web api for getting a inbody information
	 * @param memberId : member id
	 * @return pojo object of inbody
	 */
	@GetMapping("findByMemberId")
	public InbodyBean findByMemberId(Integer memberId) {
		return inbodyService.selectByMemberId(memberId);
	}
	
	/**
	 * The web api for modifying inbody
	 * @param member : member object with member id and inbody new information
	 * @return information without password for logged in member 
	 */
	@PostMapping("modify")
	public ModelMap update(@RequestBody MemberBean member) {
		InbodyStatus status = inbodyService.update(member);
		return getResultMap(status);
	}
	
	/**
	 * The external method for result mapping
	 * @param status : enum InbodyStatus
	 * @return ModelMap object
	 */
	private ModelMap getResultMap(InbodyStatus status) {
		ModelMap resultMap = new ModelMap();
		resultMap.put("code", status.getCode());
		resultMap.put("msg", status);
		return resultMap;
	}
}
