package org.typroject.tycloud.server.config.admin.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.typroject.tycloud.server.config.admin.rest.domain.UserLog;

public interface LogsService {

    /**
     * 添加用户日志
     */
    void addUserLog(UserLog userLog);

    /**
     * 查询用户登录日志
     */
    Page<UserLog> getLoginLogs(String username, Pageable pageable);

}
