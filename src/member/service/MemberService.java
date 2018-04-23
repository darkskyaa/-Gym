package member.service;

import static util.MemberUtil.*;
import java.util.List;

import member.dao.MemberDao;
import member.pojo.MemberBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	public String register(MemberBean member) {
		StringBuilder resultMessage = checkMember(member, false);
		if (resultMessage.toString().equals("")) {
			if (memberDao.selectByAccount(member.getAccount()) == null) {
				Integer id = memberDao.insert(member);
				if (id != null && id > 0) {
					resultMessage.append("register success");
				} else {
					resultMessage.append("register failure");
				}
			} else {
				resultMessage.append("account was exited");
			}
		}
		return resultMessage.toString(); 
	}

	public MemberBean selectById(Integer id) {
		return memberDao.selectById(id);
	}
	
	public List<MemberBean> getAll() {
		return memberDao.getAll();
	}

}
