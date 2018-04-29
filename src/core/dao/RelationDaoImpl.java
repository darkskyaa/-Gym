package core.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class RelationDaoImpl implements RelationDao {
	private DataSource dataSource;
	private SimpleJdbcInsert simpleJdbcInsert;
	private String tableName;
	private String[] columns;
	
	@Override
	public Integer insert(Integer id1, Integer id2) {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.withTableName(tableName);
		simpleJdbcInsert.usingGeneratedKeyColumns("ID");
		simpleJdbcInsert.usingColumns(columns);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(columns[0], id1);
		paramMap.put(columns[1], id2);
		paramMap.put("CREATOR", "SYSTEM");
		return simpleJdbcInsert.executeAndReturnKey(paramMap).intValue();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}
}
