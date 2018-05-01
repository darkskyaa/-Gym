package member.controller;

import static util.Constant.BIRTH_DATE_FORMAT;

import java.util.Date;

import member.enums.MemberStatus;
import member.pojo.MemberBean;
import member.service.MemberService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller of Member subsystem
 * @date 2018-04-14
 * @category Member
 * @author William
 */
@RestController
@RequestMapping("member")
public class MemberController {
	private static Logger logger = Logger.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	/**
	 * The web api for getting a member information
	 * @param id : member id
	 * @return pojo object of member
	 */
	@GetMapping("findMemberById")
	public MemberBean findMemberById(Integer id) {
		if (id == null) {
			return null;
		}
		return memberService.selectById(id);
	}

	/**
	 * The we api for register a member
	 * @param member : new member information
	 * @return result map for register
	 */
	@PostMapping("register")
	public ModelMap register(@RequestBody MemberBean member) {
		member.setPoint(0);
		MemberStatus status = memberService.register(member);
		ModelMap resultMap = new ModelMap();
		resultMap.put("code", status.getCode());
		resultMap.put("msg", status);
		return resultMap;
	}
	
	/**
	 * The web api for member login
	 * @param member : login member information
	 * @return information without password for logged in member 
	 */
	@PostMapping("login")
	public MemberBean login(@RequestBody MemberBean member) {
		return memberService.login(member.getAccount(), member.getPassword());
	}
	
	/**
	 * The bind method for type "String" and "Date"
	 * @param binder
	 */
	@InitBinder
	void dataBinderInit(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(BIRTH_DATE_FORMAT, true));
	}
}
