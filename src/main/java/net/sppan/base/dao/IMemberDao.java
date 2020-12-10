package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Member;
import net.sppan.base.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao extends IBaseDao<Member, Integer> {

	User findByName(String name);

}
