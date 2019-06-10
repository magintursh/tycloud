package org.typroject.tycloud.server.configadmin.face.orm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.typroject.tyboot.core.rdbms.orm.entity.BaseEntity;

/**
 * <p>
 * 需要加密的key
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
@TableName("config_encryptkey")
public class ConfigEncryptkey extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @TableField("EKEY")
    private String ekey;


    public String getEkey() {
        return ekey;
    }

    public void setEkey(String ekey) {
        this.ekey = ekey;
    }
}

