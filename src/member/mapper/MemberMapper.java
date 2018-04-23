package member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import member.pojo.MemberBean;

public class MemberMapper implements RowMapper<MemberBean> {

	@Override
	public MemberBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberBean member = new MemberBean();
		member.setId(rs.getInt(1));
		member.setAccount(rs.getString(2));
		member.setPassword(rs.getString(3));
		member.setName(rs.getString(4));
		member.setSex(rs.getInt(5));
		member.setBirthday(rs.getTimestamp(6));
		member.setPhone(rs.getString(7));
		member.setEmail(rs.getString(8));
		member.setAddr(rs.getString(9));
		member.setPhone(rs.getString(10));
		member.setRemark(rs.getString(11));
		member.setPoint(rs.getInt(12));
		member.setCreator(rs.getString(13));
		member.setCreatedDatetime(rs.getTimestamp(14));
		member.setModifier(rs.getString(15));
		member.setModifiedDatetime(rs.getTimestamp(16));
		return member;
	}
}
