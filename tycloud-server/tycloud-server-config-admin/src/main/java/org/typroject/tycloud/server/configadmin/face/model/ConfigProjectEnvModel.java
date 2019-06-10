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
public class ConfigProjectEnvModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名
     */
    private Long projectSeq;
    private Long envSeq;


    public Long getProjectSeq() {
        return projectSeq;
    }

    public void setProjectSeq(Long projectSeq) {
        this.projectSeq = projectSeq;
    }

    public Long getEnvSeq() {
        return envSeq;
    }

    public void setEnvSeq(Long envSeq) {
        this.envSeq = envSeq;
    }

}
