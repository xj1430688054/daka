package net.sppan.base.service.impl;

import net.sppan.base.common.utils.MD5Utils;
import net.sppan.base.dao.IMemberDao;
import net.sppan.base.dao.IUserDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Member;
import net.sppan.base.entity.Role;
import net.sppan.base.entity.User;
import net.sppan.base.service.IMemberService;
import net.sppan.base.service.IRoleService;
import net.sppan.base.service.IUserService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 用户账户表  服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, Integer> implements IMemberService {

	@Autowired
	private IMemberDao memberDao;
	
	@Autowired
	private IRoleService roleService;
	
	@Override
	public IBaseDao<Member, Integer> getBaseDao() {
		return this.memberDao;
	}

//	@Override
//	public User findByUserName(String username) {
//		return memberDao.findByUserName(username);
//	}

	@Override
	public void saveOrUpdate(Member user) {
		if(user.getId() != null){
			Member dbUser = find(user.getId());
			dbUser.setOpenid(user.getOpenid());
			dbUser.setName(user.getName());
			dbUser.setUpdatetime(new Date());
//			dbUser.set
//			dbUser.setEmail(user.getEmail());
//			dbUser.setAddress(user.getAddress());
//			dbUser.setLocked(user.getLocked());
//			dbUser.setDescription(user.getDescription());
//			dbUser.setUpdateTime(new Date());
			update(dbUser);
		}else{
			user.setValidstatus("1");
			user.setCreatetime(new Date());
//			user.setUpdatetime(new Date());
//			user.setDeleteStatus(0);
//			user.setPassword(MD5Utils.md5("111111"));
			save(user);
		}
	}
	
	

	@Override
	public void delete(Integer id) {
//		Member user = find(id);
//		Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能删除");
		super.delete(id);
	}

	//@Override
	//public void grant(Integer id, String[] roleIds) {
	//	Member user = find(id);
	//	Assert.notNull(user, "用户不存在");
	//	Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能修改管理角色");
	//	Role role;
	//	Set<Role> roles = new HashSet<Role>();
	//	if(roleIds != null){
	//		for (int i = 0; i < roleIds.length; i++) {
	//			Integer rid = Integer.parseInt(roleIds[i]);
	//			role = roleService.find(rid);
	//			roles.add(role);
	//		}
	//	}
	//	user.setRoles(roles);
	//	update(user);
	//}
	
}
