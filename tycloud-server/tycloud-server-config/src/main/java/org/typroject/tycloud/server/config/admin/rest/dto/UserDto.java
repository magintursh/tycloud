package org.typroject.tycloud.server.config.admin.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 角色权限
     * {@link org.typroject.tycloud.server.config.admin.rest.constant.UserRoleEnum}
     */
    private Integer role;

}
