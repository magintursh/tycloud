package org.typroject.tycloud.server.config.admin.rest.config;

import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.typroject.tycloud.server.config.admin.rest.constant.UserLogTypeEnum;
import org.typroject.tycloud.server.config.admin.rest.domain.UserLog;
import org.typroject.tycloud.server.config.admin.rest.dto.base.WebResp;
import org.typroject.tycloud.server.config.admin.rest.service.LogsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Created by Anoyi on 2018/8/7.
 * <p>
 * Blog: https://anoyi.com/
 * Github: https://github.com/ChineseSilence
 */
public class SccaAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final LogsService logsService;

    SccaAuthenticationSuccessHandler(LogsService logsService){
        this.logsService = logsService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User user = (User)authentication.getPrincipal();
        UserLog userLog = newLoginLog(user.getUsername());
        logsService.addUserLog(userLog);
        WebResp<String> response = WebResp.success("login success");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        httpServletResponse.getWriter().write(JSON.toJSONString(response));
    }

    private UserLog newLoginLog(String username){
        UserLog log = new UserLog();
        log.setCreateTime(new Date());
        log.setType(UserLogTypeEnum.LOGIN.getCode());
        log.setUsername(username);
        return log;
    }

}
