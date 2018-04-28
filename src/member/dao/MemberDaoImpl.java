package member.dao;

import static util.Constant.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.mapper.MemberMapper;
import member.pojo.MemberBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;
	
	@Override
	public Integer insert(MemberBean member) throws ParseException {
		simpleJdbcInsert.withTableName("MEMBER");
		simpleJdbcInsert.usingGeneratedKeyColumns("ID");
		simpleJdbcInsert.usingColumns(new String[] { "ACCOUNT", "PASSWORD",
				"NAME", "SEX", "BIRTHDAY", "PHONE", "EMAIL", "ADDR", "PHOTO",
				"REMARK", "POINT", "CREATOR" });
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ACCOUNT", member.getAccount());
		paramMap.put("PASSWORD", member.getPassword());
		paramMap.put("NAME", member.getName());
		paramMap.put("SEX", member.getSex());
		paramMap.put("BIRTHDAY", STANDARD_DATE_FORMAT.parseObject(member.getBirthday()));
		paramMap.put("PHONE", member.getPhone());
		paramMap.put("ADDR", member.getAddr());
		paramMap.put("PHOTO", member.getPhoto());
		paramMap.put("REMARK", member.getRemark());
		paramMap.put("POINT", member.getPoint());
		paramMap.put("CREATOR", "SYSTEM");
		return simpleJdbcInsert.executeAndReturnKey(paramMap).intValue();
	}

	@Override
	public int delete(Integer id) {
		// TODO unimplemented
		return -1;
	}
	
	@Override
	public int update(MemberBean member) {
		//TODO unimplemented
		return -1;
	}
	
	@Override
	public MemberBean selectById(Integer id) {
		String sql = "select * from MEMBER where ID = ?";
		List<MemberBean> list = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<MemberBean>(MemberBean.class)); 
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Integer selectByAccount(String account) {
		String sql = "select 1 from MEMBER where ACCOUNT = ?";
		List<Integer> list = jdbcTemplate.queryForList(sql, new Object[]{account}, Integer.class);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public MemberBean selectByAccountAndPassword(String account, String password) {
		String sql = "select * from MEMBER where ACCOUNT = ? and PASSWORD = ?";
		List<MemberBean> list = jdbcTemplate.query(sql, new Object[]{account, password}, new BeanPropertyRowMapper<MemberBean>(MemberBean.class));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public List<MemberBean> getAll() {
		return jdbcTemplate.query("select * from MEMBER", new MemberMapper());
	}

}
