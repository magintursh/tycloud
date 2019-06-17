package org.typroject.tycloud.server.config.admin.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.typroject.tycloud.server.config.admin.rest.domain.Permission;

import java.util.List;

@Data
@NoArgsConstructor
public class PermissionParamDto {

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 权限列表
     */
    List<Permission> permissions;

}
