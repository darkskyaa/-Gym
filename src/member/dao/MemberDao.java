package member.dao;

import java.util.List;

import member.pojo.MemberBean;

public interface MemberDao {

	public abstract Integer insert(MemberBean member);

	public abstract int delete(Integer id);

	public abstract int update(MemberBean member);

	public abstract MemberBean selectById(Integer id);

	public abstract Integer selectByAccount(String account);

	public abstract List<MemberBean> getAll();

}