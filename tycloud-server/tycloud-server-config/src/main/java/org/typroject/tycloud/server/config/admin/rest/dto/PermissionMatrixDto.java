package org.typroject.tycloud.server.config.admin.rest.dto;

import lombok.Data;
import org.typroject.tycloud.server.config.admin.core.domain.Env;
import org.typroject.tycloud.server.config.admin.core.domain.Project;
import org.typroject.tycloud.server.config.admin.rest.domain.Permission;

import java.util.List;

/**
 * 用户权限矩阵
 */
@Data
public class PermissionMatrixDto {

    // 环境列表
    private List<Env> envs;

    // 项目列表
    private List<Project> projects;

    // 权限矩阵
    private List<Permission> permissions;

}
