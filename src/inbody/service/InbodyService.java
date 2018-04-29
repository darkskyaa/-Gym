package inbody.service;

import static util.CommonUtil.checkInbody;

import java.util.List;

import inbody.dao.InbodyDao;
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
	public String add(MemberBean member) {
		InbodyBean inbody = member.getInbody();
		StringBuilder resultMessage = checkInbody(inbody, false);
		try {
			if (resultMessage.toString().equals("")) {
				Integer id = inbodyDao.insert(inbody);
				if (id != null && id > 0) {
					id = memberInbodyDao.insert(member.getId(), id);
					if (id != null && id > 0) {
						resultMessage.append("add success");
					} else {
						throw new Exception("insert failure, rollback");
					}
				} else {
					resultMessage.append("add failure");
				}
			}
		} catch (Exception e) {
			resultMessage.append("add failure");
			logger.error(e.getMessage());
		}
		return resultMessage.toString();
	}
	
	public InbodyBean selectByMemberId(Integer memberId) {
		List<InbodyBean> list = inbodyDao.selectByMemberId(memberId);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
