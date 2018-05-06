package inbody.dao;

import java.util.List;

import inbody.pojo.InbodyBean;

public interface InbodyDao {

	public abstract Integer insert(InbodyBean inbody);
	
	public abstract int update(Integer memberId, InbodyBean inbody);

	public abstract List<InbodyBean> selectByMemberId(Integer memberId);

}