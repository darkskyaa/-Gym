package member.service;

import java.util.List;

import member.dao.MemberDao;
import member.pojo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 後台管理者
 * 
 *
 */
@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;

	public List<Member> getAll() {
		return memberDao.getAll();
	}

}
