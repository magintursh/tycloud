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
public class ConfigProjectModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名
     */
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
