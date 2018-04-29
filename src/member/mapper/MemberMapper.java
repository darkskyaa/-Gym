package member.mapper;

import static util.Constant.BIRTH_DATE_FORMAT;
import static util.Constant.STANDARD_DATE_FORMAT;
import static util.CommonUtil.timestamp2String;

import java.sql.ResultSet;
import java.sql.SQLException;

import member.pojo.MemberBean;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<MemberBean> {

	@Override
	public MemberBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberBean member = new MemberBean();
		member.setId(rs.getInt(1));
		member.setAccount(rs.getString(2));
		member.setPassword(rs.getString(3));
		member.setName(rs.getString(4));
		member.setSex(rs.getInt(5));
		member.setBirthday(timestamp2String(rs.getTimestamp(6), BIRTH_DATE_FORMAT));
		member.setPhone(rs.getString(7));
		member.setAddr(rs.getString(8));
		member.setPhone(rs.getString(9));
		member.setRemark(rs.getString(10));
		member.setPoint(rs.getInt(11));
		member.setCreator(rs.getString(12));
		member.setCreatedDatetime(timestamp2String(rs.getTimestamp(13), STANDARD_DATE_FORMAT));
		member.setModifier(rs.getString(14));
		member.setModifiedDatetime(timestamp2String(rs.getTimestamp(15), STANDARD_DATE_FORMAT));
		return member;
	}
}
