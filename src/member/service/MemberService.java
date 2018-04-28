package member.service;

import static util.MemberUtil.checkMember;
import static util.Crypto.*;

import java.text.ParseException;
import java.util.List;

import member.dao.MemberDao;
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
	public String register(MemberBean member) {
		StringBuilder resultMessage = checkMember(member, false);
		try {
			if (resultMessage.toString().equals("")) {
				if (memberDao.selectByAccount(member.getAccount()) == null) {
					member.setPassword(toMD5(member.getPassword()));
					Integer id = memberDao.insert(member);
					if (id != null && id > 0) {
						resultMessage.append("register success");
					} else {
						resultMessage.append("register failure");
					}
				} else {
					resultMessage.append("account was existed");
				}
			}
		} catch (ParseException e) {
			resultMessage.append("register failure");
			logger.error(e.getMessage());
		}
		return resultMessage.toString(); 
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
