package org.typroject.tycloud.server.config.admin.rest.service;

import org.typroject.tycloud.server.config.admin.rest.domain.Permission;
import org.typroject.tycloud.server.config.admin.rest.domain.User;

import java.util.List;

/**
 * Created by Anoyi on 2018/10/24.
 * <p>
 * Blog: https://anoyi.com/
 * Github: https://github.com/ChineseSilence
 */
public interface PermissionService {

    /**
     * 查询用户权限
     */
    List<Permission> getPermission(Long userId);

    /**
     * 更新用户权限
     */
    void updatePermission(Long userId, List<Permission> permissionList);

    /**
     * 权限过滤
     */
    void permissionFilter(User user, String env, String project);

}
