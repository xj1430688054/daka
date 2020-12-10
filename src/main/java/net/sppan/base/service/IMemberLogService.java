package net.sppan.base.service;

import net.sppan.base.entity.Member;
import net.sppan.base.entity.MemberLog;
import net.sppan.base.service.support.IBaseService;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface IMemberLogService extends IBaseService<MemberLog, Integer> {

//	/**
//	 * 修改或者新增资源
//	 * @param resource
//	 */
	void save(MemberLog resource);



}
