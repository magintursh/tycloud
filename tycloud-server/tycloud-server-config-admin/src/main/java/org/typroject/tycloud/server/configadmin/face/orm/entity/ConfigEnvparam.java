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
@TableName("config_envparam")
public class ConfigEnvparam extends BaseEntity {

	private static final long serialVersionUID = 1L;


	/**
	 * 环境名
	 */
	@TableField("PKEY")
	private String pkey;
	/**
	 * 注册中心地址，如果为空，配置中心的访问地址不使用服务名 registry_Address
	 */
	@TableField("PVALUE")
	private String pvalue;
	@TableField("ENV_SEQ")
	private Long envSeq;



public String getPkey() {
		return pkey;
		}
public void setPkey(String pkey){
		this.pkey = pkey;
}
public String getPvalue() {
		return pvalue;
		}
public void setPvalue(String pvalue){
		this.pvalue = pvalue;
}
public Long getEnvSeq() {
		return envSeq;
		}
public void setEnvSeq(Long envSeq){
		this.envSeq = envSeq;
}
}

