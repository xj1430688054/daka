package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.MemberLog;
import net.sppan.base.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberLogDao extends IBaseDao<MemberLog, Integer> {

//	User findByName(String name);

}
