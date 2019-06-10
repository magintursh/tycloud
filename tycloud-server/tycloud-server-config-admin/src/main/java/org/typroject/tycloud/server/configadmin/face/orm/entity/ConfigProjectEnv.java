package org.typroject.tycloud.server.configadmin.face.orm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.typroject.tyboot.core.rdbms.orm.entity.BaseEntity;

/**
 * <p>
 * 环境属性
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
@TableName("config_project_env")
public class ConfigProjectEnv extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**
	 * 项目名
	 */
	@TableField("PROJECT_SEQ")
	private Long projectSeq;
	@TableField("ENV_SEQ")
	private Long envSeq;



public Long getProjectSeq() {
		return projectSeq;
		}
public void setProjectSeq(Long projectSeq){
		this.projectSeq = projectSeq;
}
public Long getEnvSeq() {
		return envSeq;
		}
public void setEnvSeq(Long envSeq){
		this.envSeq = envSeq;
}
}

