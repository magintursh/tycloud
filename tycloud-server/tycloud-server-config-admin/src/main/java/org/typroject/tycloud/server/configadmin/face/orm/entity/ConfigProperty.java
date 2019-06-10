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
@TableName("config_property")
public class ConfigProperty extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 项目名
     */
    @TableField("PKEY")
    private String pkey;
    @TableField("PVALUE")
    private String pvalue;
    @TableField("ENV_SEQ")
    private Long envSeq;
    @TableField("PROPERTY_SEQ")
    private Long propertySeq;
    @TableField("LABEL_SEQ")
    private Long labelSeq;


    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public Long getEnvSeq() {
        return envSeq;
    }

    public void setEnvSeq(Long envSeq) {
        this.envSeq = envSeq;
    }

    public Long getPropertySeq() {
        return propertySeq;
    }

    public void setPropertySeq(Long propertySeq) {
        this.propertySeq = propertySeq;
    }

    public Long getLabelSeq() {
        return labelSeq;
    }

    public void setLabelSeq(Long labelSeq) {
        this.labelSeq = labelSeq;
    }
}

