package org.typroject.tycloud.server.configadmin.face.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.typroject.tyboot.core.foundation.utils.ValidationUtil;
import org.typroject.tyboot.core.rdbms.service.BaseService;
import org.typroject.tycloud.server.configadmin.face.model.ConfigProjectEnvModel;
import org.typroject.tycloud.server.configadmin.face.model.ConfigProjectModel;
import org.typroject.tycloud.server.configadmin.face.orm.dao.ConfigProjectMapper;
import org.typroject.tycloud.server.configadmin.face.orm.entity.ConfigProject;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 环境属性 服务类
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
@Component
public class ConfigProjectService extends BaseService<ConfigProjectModel,ConfigProject,ConfigProjectMapper> {


    @Autowired
    private ConfigProjectEnvService configProjectEnvService;

    public List<ConfigProjectModel> queryByEnv(Long envSeq) throws Exception
    {
        List<ConfigProjectModel> returnList = new ArrayList<>();
        List<ConfigProjectEnvModel>  projectEnvModels = configProjectEnvService.queryByEnv(null,envSeq);
        if(!ValidationUtil.isEmpty(projectEnvModels))
            for(ConfigProjectEnvModel projectEnvModel:projectEnvModels)
                returnList.add(this.queryBySeq(projectEnvModel.getProjectSeq()));
        return returnList;



    }

}
