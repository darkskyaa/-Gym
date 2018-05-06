package inbody.service;

import static inbody.enums.InbodyStatus.*;

import java.util.List;

import inbody.dao.InbodyDao;
import inbody.enums.InbodyStatus;
import inbody.pojo.InbodyBean;
import member.pojo.MemberBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.dao.RelationDao;

@Service
public class InbodyService {
	private static Logger logger = Logger.getLogger(InbodyService.class);
	@Autowired
	private InbodyDao inbodyDao;
	@Autowired
	private RelationDao memberInbodyDao;
	
	@Transactional
	public InbodyStatus add(MemberBean member) {
		InbodyBean inbody = member.getInbody();
		try {
			Integer id = inbodyDao.insert(inbody);
			if (id != null && id > 0) {
				id = memberInbodyDao.insert(member.getId(), id);
				if (id != null && id > 0) {
					return SUCCESS;
				} else {
					throw new Exception("insert MEMBER_INBODY failure, rollback");
				}
			} else {
				return FAILURE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return FAILURE;
		}
	}
	
	@Transactional
	public InbodyStatus update(MemberBean member) {
		int result = inbodyDao.update(member.getId(), member.getInbody());
		if (result > 0) {
			return SUCCESS; 
		} else {
			return FAILURE;
		}
	}
	
	public InbodyBean selectByMemberId(Integer memberId) {
		List<InbodyBean> list = inbodyDao.selectByMemberId(memberId);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
