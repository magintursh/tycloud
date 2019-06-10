package org.typroject.tycloud.server.configadmin.face.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.typroject.tyboot.core.foundation.utils.ValidationUtil;
import org.typroject.tycloud.server.configadmin.face.model.ConfigEnvModel;
import org.typroject.tycloud.server.configadmin.face.orm.dao.ConfigEnvMapper;
import org.typroject.tycloud.server.configadmin.face.orm.entity.ConfigEnv;

import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.typroject.tyboot.core.rdbms.service.BaseService;
import sun.security.krb5.Config;

import java.util.List;


/**
 * <p>
 * 环境 服务类
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
@Component
public class ConfigEnvService extends BaseService<ConfigEnvModel,ConfigEnv,ConfigEnvMapper> {


    @Autowired
    private ConfigProjectService configProjectService;
    @Autowired
    private ConfigEnvparamService configEnvparamService;

    public List<ConfigEnvModel> queryForDashboard()throws Exception
    {
        List<ConfigEnvModel> models = this.queryForList("",false,new String[]{});

        if(!ValidationUtil.isEmpty(models))
            for(ConfigEnvModel envModel:models)
            {
                envModel.setProjectModels(configProjectService.queryByEnv(envModel.getSequenceNbr()));
                envModel.setEnvParams(configEnvparamService.queryByEnv(envModel.getSequenceNbr()));

                envModel.setId(envModel.getSequenceNbr());
                envModel.setProjects(envModel.getProjectModels().size());
                envModel.setParams(envModel.getEnvParams().size());
            }
        return models;
    }
}
