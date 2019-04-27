package org.typroject.tycloud.api.systemctl.face.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;
import org.typroject.tycloud.api.systemctl.face.model.DictionarieValueModel;
import org.typroject.tycloud.api.systemctl.face.orm.dao.DictionarieValueMapper;
import org.typroject.tycloud.api.systemctl.face.orm.entity.DictionarieValue;
import org.typroject.tyboot.core.rdbms.service.BaseService;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author magintursh
 * @since 2017-06-27
 */
@Component
public class DictionarieValueService extends BaseService<DictionarieValueModel,DictionarieValue,DictionarieValueMapper> implements IService<DictionarieValue> {



    public DictionarieValueModel selectByCodeAndKey(String agencyCode,String dictCode,String dictDataKey) throws Exception
    {
        return this.queryModelByParams(agencyCode,dictCode,dictDataKey);
    }



}
