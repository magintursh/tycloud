package org.typroject.tycloud.server.configadmin.face.model;

import org.typroject.tyboot.core.rdbms.model.BaseModel;

    /**
     * <p>
     * 需要加密的key
     * </p>
     *
     * @author 子杨
     * @since 2019-05-22
     */
    public class ConfigEncryptkeyModel extends BaseModel {

        private static final long serialVersionUID = 1L;

            private String ekey;


        public String getEkey() {
            return ekey;
        }
        public void setEkey(String ekey) {
            this.ekey = ekey;
        }

    }
