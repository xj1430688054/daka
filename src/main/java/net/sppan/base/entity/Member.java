package net.sppan.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 用户账户表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Data
@Entity
@Table(name = "tb_member")
public class Member extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 账户名
	 */
	private String name;

	/**
	 * 昵称
	 */
	private String openid;

	/**
	 * 用户密码
	 */
	private String validstatus;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 修改时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updatetime;

	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createtime;





}
