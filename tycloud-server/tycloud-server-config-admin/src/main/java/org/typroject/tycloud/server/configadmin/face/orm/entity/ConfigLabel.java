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
@TableName("config_label")
public class ConfigLabel extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**
	 * 标签名
	 */
	@TableField("NAME")
	private String name;
	@TableField("PROJECT_SEQ")
	private Long projectSeq;



public String getName() {
		return name;
		}
public void setName(String name){
		this.name = name;
}
public Long getProjectSeq() {
		return projectSeq;
		}
public void setProjectSeq(Long projectSeq){
		this.projectSeq = projectSeq;
}
}

