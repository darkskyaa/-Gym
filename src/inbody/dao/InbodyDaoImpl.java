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
	public List<InbodyBean> selectByMemberId(Integer memberId) {
		String sql = "select i.* from MEMBER_INBODY mi left join INBODY i on mi.INBODY_ID = i.ID where mi.MEMBER_ID = ? order by i.CREATED_DATETIME desc";
		List<InbodyBean> list = jdbcTemplate.query(sql, new Object[]{memberId}, new InbodyMapper()); 
		return list;
	}
}
