package member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import member.pojo.MemberBean;

import org.springframework.jdbc.core.RowMapper;

/**
 * The mapper of Member subsystem
 * @date 2018-04-23
 * @category Member
 * @author William
 */
public class MemberMapper implements RowMapper<MemberBean> {

	@Override
	public MemberBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberBean member = new MemberBean();
		member.setId(rs.getInt(1));
		member.setAccount(rs.getString(2));
		member.setPassword(rs.getString(3));
		member.setRole(rs.getInt(4));
		member.setName(rs.getString(5));
		member.setSex(rs.getInt(6));
		member.setBirthday(rs.getTimestamp(7));
		member.setPhone(rs.getString(8));
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
