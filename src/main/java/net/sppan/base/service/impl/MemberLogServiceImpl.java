package net.sppan.base.service.impl;

import net.sppan.base.dao.IMemberDao;
import net.sppan.base.dao.IMemberLogDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Member;
import net.sppan.base.entity.MemberLog;
import net.sppan.base.service.IMemberLogService;
import net.sppan.base.service.IMemberService;
import net.sppan.base.service.IRoleService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用户账户表  服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class MemberLogServiceImpl extends BaseServiceImpl<MemberLog, Integer> implements IMemberLogService {

	@Autowired
	private IMemberLogDao memberDao;
	
	@Autowired
	private IRoleService roleService;
	
	@Override
	public IBaseDao<MemberLog, Integer> getBaseDao() {
		return this.memberDao;
	}



	@Override
	public void save(MemberLog user) {
			user.setInputtime(new Date());
			save(user);

	}
	
	

	@Override
	public void delete(Integer id) {

		super.delete(id);
	}




	
}
