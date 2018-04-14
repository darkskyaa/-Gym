package member.dao;

import java.util.List;

import member.pojo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate simpleJdbc;
	
	public List<Member> getAll() {
		return simpleJdbc.query("select * from MEMBER", (rs, num) -> {
			Member member = new Member();
			member.setId(rs.getInt(1));
			member.setName(rs.getString(2));
			return member;
		});
	}
}
