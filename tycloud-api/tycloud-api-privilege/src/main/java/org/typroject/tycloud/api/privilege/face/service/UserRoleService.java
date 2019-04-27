package org.typroject.tycloud.api.privilege.face.service;

import org.springframework.stereotype.Service;
import org.typroject.tycloud.api.privilege.face.model.UserRoleModel;
import org.typroject.tycloud.api.privilege.face.orm.dao.UserRoleMapper;
import org.typroject.tycloud.api.privilege.face.orm.entity.UserRole;
import org.typroject.tyboot.core.rdbms.service.BaseService;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author magintursh
 * @since 2017-08-18
 */
@Service
public class UserRoleService extends BaseService<UserRoleModel,UserRole,UserRoleMapper> {


    public List<UserRoleModel> selectRoleByUser(String userId, String agencyCode) throws Exception
    {
        return this.queryForList(null,false,userId,agencyCode);
    }






}
