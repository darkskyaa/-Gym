package member.dao;

import java.text.ParseException;
import java.util.List;

import member.pojo.MemberBean;

/**
 * The dao interface of Member subsystem
 * @date 2018-04-23
 * @category Member
 * @author William
 */
public interface MemberDao {

	/**
	 * Insert method for member
	 * @param member : member information 
	 * @return generated member id
	 * @throws ParseException
	 */
	public abstract Integer insert(MemberBean member) throws ParseException;

	public abstract int delete(Integer id);

	public abstract int update(MemberBean member);

	/**
	 * Select method for find a member
	 * @param id : member id
	 * @return member id by database generated
	 */
	public abstract MemberBean selectById(Integer id);

	/**
	 * Select method for find a member
	 * @param account : member account
	 * @return 1 : existed. null : not exist
	 */
	public abstract Integer selectByAccount(String account);
	
	/**
	 * Select method for find a member
	 * @param account : member account
	 * @param password : member password
	 * @return member information. null for not exist
	 */
	public abstract MemberBean selectByAccountAndPassword(String account, String password);

	/**
	 * Select method for find all members
	 * @return all members information. null for not exist
	 */
	public abstract List<MemberBean> getAll();

}