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
		member.setName(rs.getString(4));
		member.setSex(rs.getInt(5));
		member.setBirthday(rs.getTimestamp(6));
		member.setPhone(rs.getString(7));
		member.setAddr(rs.getString(8));
		member.setPhone(rs.getString(9));
		member.setRemark(rs.getString(10));
		member.setPoint(rs.getInt(11));
		member.setCreator(rs.getString(12));
		member.setCreatedDatetime(rs.getTimestamp(13));
		member.setModifier(rs.getString(14));
		member.setModifiedDatetime(rs.getTimestamp(15));
		return member;
	}
}
