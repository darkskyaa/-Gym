package member.mapper;

import static util.Constant.*;
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
		member.setBirthday(BIRTH_DATE_FORMAT.format(rs.getTimestamp(6)));
		member.setPhone(rs.getString(7));
		member.setAddr(rs.getString(8));
		member.setPhone(rs.getString(9));
		member.setRemark(rs.getString(10));
		member.setPoint(rs.getInt(11));
		member.setCreator(rs.getString(12));
		member.setCreatedDatetime(STANDARD_DATE_FORMAT.format(rs.getTimestamp(13)));
		member.setModifier(rs.getString(14));
		member.setModifiedDatetime(STANDARD_DATE_FORMAT.format(rs.getTimestamp(15)));
		return member;
	}
}
