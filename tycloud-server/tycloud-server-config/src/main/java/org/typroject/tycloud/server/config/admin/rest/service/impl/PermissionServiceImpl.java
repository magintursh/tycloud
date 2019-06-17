package org.typroject.tycloud.server.config.admin.rest.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.typroject.tycloud.server.config.admin.core.domain.Env;
import org.typroject.tycloud.server.config.admin.core.domain.EnvRepo;
import org.typroject.tycloud.server.config.admin.core.domain.Project;
import org.typroject.tycloud.server.config.admin.core.domain.ProjectRepo;
import org.typroject.tycloud.server.config.admin.rest.constant.UserRoleEnum;
import org.typroject.tycloud.server.config.admin.rest.domain.Permission;
import org.typroject.tycloud.server.config.admin.rest.domain.PermissionRepo;
import org.typroject.tycloud.server.config.admin.rest.domain.User;
import org.typroject.tycloud.server.config.admin.rest.exception.ServiceException;
import org.typroject.tycloud.server.config.admin.rest.service.PermissionService;
import org.typroject.tycloud.server.config.admin.rest.service.UserService;

import java.util.List;

/**
 * Created by Anoyi on 2018/8/1.
 * <p>
 * Blog: https://anoyi.com/
 * Github: https://github.com/ChineseSilence
 */
@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepo permissionRepo;

    private final EnvRepo envRepo;

    private final ProjectRepo projectRepo;

    private final UserService userService;

    @Override
    public List<Permission> getPermission(Long userId) {
        if (!userService.existUser(userId)) {
            throw new ServiceException("用户不存在");
        }
        Sort sort = new Sort(Sort.Direction.ASC, "envId", "projectId");
        return permissionRepo.findAllByUserId(userId, sort);
    }

    @Override
    @Transactional
    public void updatePermission(Long userId, List<Permission> permissionList) {
        if (!userService.existUser(userId)) {
            throw new ServiceException("用户不存在");
        }
        permissionList.forEach(permission -> {
            if (!checkPermissionAttr(permission)) {
                throw new ServiceException("参数不完整");
            }
        });
        permissionRepo.deleteAllByUserId(userId);
        permissionRepo.saveAll(permissionList);
    }

    @Override
    public void permissionFilter(User user, String env, String project) {
        if (UserRoleEnum.ADMIN.getKey().equals(user.getRole())){
            return;
        }

        Env envObj = envRepo.findByName(env);
        if (envObj == null){
            throw new ServiceException("环境不存在");
        }
        Project projectObj = projectRepo.findByName(project);
        if (projectObj == null){
            throw new ServiceException("项目不存在");
        }
        Permission permission = permissionRepo.findByUserIdAndEnvIdAndProjectId(user.getId(), envObj.getId(), projectObj.getId());
        if (permission == null){
            throw new ServiceException("无权操作");
        }
    }

    private boolean checkPermissionAttr(Permission permission) {
        return permission.getEnvId() != null
                && permission.getProjectId() != null;
    }

}