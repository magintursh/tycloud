package org.typroject.tycloud.api.privilege.face.service;

import org.springframework.stereotype.Service;
import org.typroject.tycloud.api.privilege.face.model.AgencyMenuModel;
import org.typroject.tycloud.api.privilege.face.orm.dao.AgencyMenuMapper;
import org.typroject.tycloud.api.privilege.face.orm.entity.AgencyMenu;
import org.typroject.tyboot.core.rdbms.service.BaseService;

/**
 * <p>
 * 角色与菜单关系表 服务实现类
 * </p>
 *
 * @author magintursh
 * @since 2017-08-18
 */
@Service
public class AgencyMenuService extends BaseService<AgencyMenuModel,AgencyMenu,AgencyMenuMapper>  {
	
}
