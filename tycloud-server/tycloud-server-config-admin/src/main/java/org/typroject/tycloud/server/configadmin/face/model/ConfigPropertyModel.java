package org.typroject.tycloud.server.configadmin.face.model;

import org.typroject.tyboot.core.rdbms.model.BaseModel;

/**
 * <p>
 * 环境属性
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
public class ConfigPropertyModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名
     */
    private String pkey;
    private String pvalue;
    private Long envSeq;
    private Long propertySeq;
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
