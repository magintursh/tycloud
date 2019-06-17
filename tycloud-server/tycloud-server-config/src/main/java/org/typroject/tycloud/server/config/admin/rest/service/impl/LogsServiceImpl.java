package org.typroject.tycloud.server.config.admin.rest.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.typroject.tycloud.server.config.admin.rest.constant.UserLogTypeEnum;
import org.typroject.tycloud.server.config.admin.rest.domain.UserLog;
import org.typroject.tycloud.server.config.admin.rest.domain.UserLogRepo;
import org.typroject.tycloud.server.config.admin.rest.service.LogsService;

/**
 * Created by Anoyi on 2018/8/14.
 * <p>
 * Blog: https://anoyi.com/
 * Github: https://github.com/ChineseSilence
 */
@Service
@AllArgsConstructor
public class LogsServiceImpl implements LogsService {

    private final UserLogRepo userLogRepo;

    @Override
    public void addUserLog(UserLog userLog) {
        userLogRepo.save(userLog);
    }

    @Override
    public Page<UserLog> getLoginLogs(String username, Pageable pageable) {
        return userLogRepo.findAllByUsernameAndType(username, UserLogTypeEnum.LOGIN.getCode(), pageable);
    }

}