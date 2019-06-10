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
    public class ConfigLabelModel extends BaseModel {

        private static final long serialVersionUID = 1L;

                /**
                 * 标签名
                 */
            private String name;
            private Long projectSeq;


        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Long getProjectSeq() {
            return projectSeq;
        }
        public void setProjectSeq(Long projectSeq) {
            this.projectSeq = projectSeq;
        }

    }
