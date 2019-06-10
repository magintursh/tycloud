package org.typroject.tycloud.server.configadmin.face.service;


import org.typroject.tycloud.server.configadmin.face.model.ConfigEncryptkeyModel;
import org.typroject.tycloud.server.configadmin.face.orm.dao.ConfigEncryptkeyMapper;
import org.typroject.tycloud.server.configadmin.face.orm.entity.ConfigEncryptkey;

import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.typroject.tyboot.core.rdbms.service.BaseService;
import java.util.List;


/**
 * <p>
 * 需要加密的key 服务类
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
@Component
public class ConfigEncryptkeyService extends BaseService<ConfigEncryptkeyModel,ConfigEncryptkey,ConfigEncryptkeyMapper> {



}
