package org.typroject.tycloud.api.privilege.face.orm.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.typroject.tyboot.core.rdbms.orm.entity.BaseEntity;

import java.util.Date;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author magintursh
 * @since 2017-08-18
 */
@TableName("privilege_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 76324354328765L;

    /**
     * 角色名称
     */
	@TableField("ROLE_NAME")
	private String roleName;
    /**
     * 机构编码
     */
	@TableField("AGENCY_CODE")
	private String agencyCode;
    /**
     * 创建时间
     */
	@TableField("CREATE_TIME")
	private Date createTime;

    /**
     * 数据锁定状态: N :非锁定 / Y: 锁定 
     */
	@TableField("LOCK_STATUS")
	private String lockStatus;
    /**
     * 数据锁定时间
     */
	@TableField("LOCK_DATE")
	private Date lockDate;
    /**
     * 锁定人ID外键
     */
	@TableField("LOCK_USER_ID")
	private String lockUserId;

    /**
     * 创建人
     */
	@TableField("CREATE_USER_ID")
	private String createUserId;


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public Date getLockDate() {
		return lockDate;
	}

	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	public String getLockUserId() {
		return lockUserId;
	}

	public void setLockUserId(String lockUserId) {
		this.lockUserId = lockUserId;
	}


	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}


}
