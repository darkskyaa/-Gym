package member.service;

import static util.Crypto.*;
import static member.enums.MemberStatus.*;

import java.text.ParseException;
import java.util.List;

import member.dao.MemberDao;
import member.enums.MemberStatus;
import member.pojo.MemberBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The service of Member subsystem
 * @date 2018-04-14
 * @category Member
 * @author William
 */
@Service
public class MemberService {
	private static Logger logger = Logger.getLogger(MemberService.class);

	@Autowired
	private MemberDao memberDao;
	
	/**
	 * The service method for register a member
	 * @param member : new member information
	 * @return result enum for register
	 */
	@Transactional
	public MemberStatus register(MemberBean member) {
		try {
			if (memberDao.selectByAccount(member.getAccount()) == null) {
				member.setPassword(toMD5(member.getPassword()));
				Integer id = memberDao.insert(member);
				if (id != null && id > 0) {
					return SUCCESS;
				} else {
					return FAILURE;
				}
			} else {
				return FAILURE_ACCOUNT_DUPLICATE;
			}
		} catch (ParseException e) {
			logger.error(e.getMessage());
			return FAILURE;
		}
	}

	/**
	 * The service method for member login
	 * @param account : login member account
	 * @param password : login member password
	 * @return information without password for logged in member 
	 */
	public MemberBean login(String account, String password) {
		password = toMD5(password);
		MemberBean member = memberDao.selectByAccountAndPassword(account, password);
		if (member != null) member.setPassword(null);
		return member;
	}
	
	/**
	 * The service method for getting a member information
	 * @param id : member id
	 * @return pojo object of member
	 */
	public MemberBean selectById(Integer id) {
		return memberDao.selectById(id);
	}
	
	/**
	 * The service method for getting all members information
	 * @return pojo list of member
	 */
	public List<MemberBean> getAll() {
		return memberDao.getAll();
	}
}
