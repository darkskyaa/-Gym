package member.dao;

import java.text.ParseException;
import java.util.List;

import member.pojo.MemberBean;

public interface MemberDao {

	public abstract Integer insert(MemberBean member) throws ParseException;

	public abstract int delete(Integer id);

	public abstract int update(MemberBean member);

	public abstract MemberBean selectById(Integer id);

	public abstract Integer selectByAccount(String account);
	
	public abstract MemberBean selectByAccountAndPassword(String account, String password);

	public abstract List<MemberBean> getAll();

}