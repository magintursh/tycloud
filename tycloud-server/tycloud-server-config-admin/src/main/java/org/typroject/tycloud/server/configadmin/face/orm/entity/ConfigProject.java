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
@TableName("config_project")
public class ConfigProject extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**
	 * 项目名
	 */
	@TableField("NAME")
	private String name;



public String getName() {
		return name;
		}
public void setName(String name){
		this.name = name;
}
}

