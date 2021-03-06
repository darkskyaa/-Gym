package inbody.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import inbody.mapper.InbodyMapper;
import inbody.pojo.InbodyBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * The dao implementation of Inbody subsystem
 * @date 2018-04-29
 * @category Inbody
 * @author William
 */
@Repository
public class InbodyDaoImpl implements InbodyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;
	
	@Override
	public Integer insert(InbodyBean inbody) {
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("INBODY");
		simpleJdbcInsert.usingGeneratedKeyColumns("ID");
		simpleJdbcInsert.usingColumns(new String[] {"WEIGHT", "MUSCLE_MASS", "TBW",
				"PROTEINS", "MINERALS", "BONE_CONTENT", "PBF", "VFL", "BMR"});
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("WEIGHT", inbody.getWeight());
		paramMap.put("MUSCLE_MASS", inbody.getMuscleMass());
		paramMap.put("TBW", inbody.getTbw());
		paramMap.put("PROTEINS", inbody.getProteins());
		paramMap.put("MINERALS", inbody.getMinerals());
		paramMap.put("BONE_CONTENT", inbody.getBoneContent());
		paramMap.put("PBF", inbody.getPbf());
		paramMap.put("VFL", inbody.getVfl());
		paramMap.put("BMR", inbody.getBmr());
		paramMap.put("CREATOR", "SYSTEM");
		return simpleJdbcInsert.executeAndReturnKey(paramMap).intValue();
	}
	
	@Override
	public int update(Integer memberId, InbodyBean inbody) {
		String sql = "update INBODY set "
				+ "WEIGHT = ?,"
				+ "MUSCLE_MASS = ?,"
				+ "TBW = ?,"
				+ "PROTEINS = ?,"
				+ "MINERALS = ?,"
				+ "BONE_CONTENT = ?,"
				+ "PBF = ?,"
				+ "VFL = ?,"
				+ "BMR = ?,"
				+ "MODIFIER = 'SYSTEM'"
				+ "where ID = (select INBODY_ID from MEMBER_INBODY where MEMBER_ID = ?)";
		return jdbcTemplate.update(sql, inbody.getWeight(), inbody.getMuscleMass(), inbody.getTbw(), inbody.getProteins()
				, inbody.getMinerals(), inbody.getBoneContent(), inbody.getPbf(), inbody.getVfl(), inbody.getBmr(), memberId);
	}
	
	@Override
	public List<InbodyBean> selectByMemberId(Integer memberId) {
		String sql = "select i.* from MEMBER_INBODY mi left join INBODY i on mi.INBODY_ID = i.ID where mi.MEMBER_ID = ? order by i.CREATED_DATETIME desc";
		List<InbodyBean> list = jdbcTemplate.query(sql, new Object[]{memberId}, new InbodyMapper()); 
		return list;
	}
}
