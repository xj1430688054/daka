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
@Table(name = "tb_member_log")
public class MemberLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 成员id
	 */
	private Integer mid;

	/**
	 * 账户名
	 */
	private String name;

	/**
	 * 昵称
	 */
	private String openid;


	private String status;


	/**
	 * 请求类型， 1 test
	 *  2 定时
	 */
	private String datatype;

	private String msg;

	/**
	 * 插入时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date inputtime;







}
