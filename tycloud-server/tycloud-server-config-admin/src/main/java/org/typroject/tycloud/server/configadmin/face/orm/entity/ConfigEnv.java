package org.typroject.tycloud.server.configadmin.face.orm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.typroject.tyboot.core.rdbms.orm.entity.BaseEntity;

/**
 * <p>
 * 环境
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
@TableName("config_env")
public class ConfigEnv extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**
	 * 环境名
	 */
	@TableField("NAME")
	private String name;
	/**
	 * 注册中心地址，如果为空，配置中心的访问地址不使用服务名 registry_Address
	 */
	@TableField("REGISTRY_ADDRESS")
	private String registryAddress;
	/**
	 * 配置中心的访问地址（比如：http://localhost:8888/）或服务名（配置服务名的时候需要与服务发现组件配合使用）
	 */
	@TableField("CONFIG_SERVER_NAME")
	private String configServerName;
	/**
	 * 如果配置中心设置了contextPath，那么也需要维护进来
	 */
	@TableField("CONTEXT_PATH")
	private String contextPath;



public String getName() {
		return name;
		}
public void setName(String name){
		this.name = name;
}
public String getRegistryAddress() {
		return registryAddress;
		}
public void setRegistryAddress(String registryAddress){
		this.registryAddress = registryAddress;
}
public String getConfigServerName() {
		return configServerName;
		}
public void setConfigServerName(String configServerName){
		this.configServerName = configServerName;
}
public String getContextPath() {
		return contextPath;
		}
public void setContextPath(String contextPath){
		this.contextPath = contextPath;
}
}

