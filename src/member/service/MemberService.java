package member.service;

import static util.Crypto.*;
import static member.enums.MemberStatus.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import member.dao.MemberDao;
import member.enums.MemberStatus;
import member.pojo.MemberBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	private static Logger logger = Logger.getLogger(MemberService.class);

	@Autowired
	private MemberDao memberDao;
	
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

	public MemberBean login(String account, String password) {
		password = toMD5(password);
		MemberBean member = memberDao.selectByAccountAndPassword(account, password);
		if (member != null) member.setPassword(null);
		return member;
	}
	
	public MemberBean selectById(Integer id) {
		return memberDao.selectById(id);
	}
	
	public List<MemberBean> getAll() {
		return memberDao.getAll();
	}
}
