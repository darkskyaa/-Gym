package inbody.mapper;

import inbody.pojo.InbodyBean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class InbodyMapper implements RowMapper<InbodyBean> {

	@Override
	public InbodyBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		InbodyBean inbody = new InbodyBean();
		inbody.setId(rs.getInt(1));
		inbody.setWeight(rs.getDouble(2));
		inbody.setMuscleMass(rs.getDouble(3));
		inbody.setTbw(rs.getDouble(4));
		inbody.setProteins(rs.getDouble(5));
		inbody.setMinerals(rs.getDouble(6));
		inbody.setBoneContent(rs.getDouble(7));
		inbody.setPbf(rs.getDouble(8));
		inbody.setVfl(rs.getDouble(9));
		inbody.setBmr(rs.getDouble(10));
		inbody.setCreator(rs.getString(11));
		inbody.setCreatedDatetime(rs.getTimestamp(12));
		inbody.setModifier(rs.getString(13));
		inbody.setModifiedDatetime(rs.getTimestamp(14));
		return inbody;
	}
}
