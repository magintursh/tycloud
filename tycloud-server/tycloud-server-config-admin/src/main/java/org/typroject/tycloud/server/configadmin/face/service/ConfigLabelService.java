package org.typroject.tycloud.server.configadmin.face.service;


import org.typroject.tycloud.server.configadmin.face.model.ConfigLabelModel;
import org.typroject.tycloud.server.configadmin.face.orm.dao.ConfigLabelMapper;
import org.typroject.tycloud.server.configadmin.face.orm.entity.ConfigLabel;

import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.typroject.tyboot.core.rdbms.service.BaseService;
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
public class ConfigLabelService extends BaseService<ConfigLabelModel,ConfigLabel,ConfigLabelMapper> {



}
