package org.typroject.tycloud.api.systemctl.face.orm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.typroject.tyboot.core.rdbms.orm.entity.BaseEntity;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author magintursh
 * @since 2017-06-27
 */
@TableName("systemctl_dictionarie")

public class Dictionarie extends BaseEntity{

    private static final long serialVersionUID = 5648645132156L;

    /**
     * 字典编码 系统中固定不变
     */
    @TableField("DICT_CODE")
	private String dictCode;
    /**
     * 字典名字
     */
	@TableField("DICT_NAME")
	private String dictName;
    /**
     * 字典别名
     */
	@TableField("DICT_ALIAS")
	private String dictAlias;
    /**
     * 字典值描述
     */
	@TableField("DICT_DESC")
	private String dictDesc;
    /**
     * 业务类型
     */
	@TableField("BU_TYPE")
	private String buType;
    /**
     * 机构编码
     */

	@TableField("AGENCY_CODE")
	private String agencyCode;


	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictAlias() {
		return dictAlias;
	}

	public void setDictAlias(String dictAlias) {
		this.dictAlias = dictAlias;
	}

	public String getDictDesc() {
		return dictDesc;
	}

	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}

	public String getBuType() {
		return buType;
	}

	public void setBuType(String buType) {
		this.buType = buType;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}


}
