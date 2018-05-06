package inbody.dao;

import java.text.ParseException;
import java.util.List;

import inbody.pojo.InbodyBean;

/**
 * The dao interface of Inbody subsystem
 * @date 2018-04-29
 * @category Inbody
 * @author William
 */
public interface InbodyDao {

	/**
	 * Insert method for inbody
	 * @param inbody : inbody information
	 * @return generated inbody id
	 */
	public abstract Integer insert(InbodyBean inbody);
	
	/**
	 * Update method for inbody
	 * @param memberId : member id
	 * @param inbody : inbody information
	 * @return generated inbody id
	 */
	public abstract int update(Integer memberId, InbodyBean inbody);

	/**
	 * Select method for find a inbody of member
	 * @param memberId : member id
	 * @return all inbodys information about specific memberId
	 */
	public abstract List<InbodyBean> selectByMemberId(Integer memberId);

}