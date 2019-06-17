package org.typroject.tycloud.server.config.admin.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.typroject.tycloud.server.config.admin.core.service.ConfigServerInfo;

import java.util.List;

/**
 * Dashboard上使用的环境概览信息
 * <p>
 * Created by 程序猿DD/翟永超 on 2018/5/16.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Data
@NoArgsConstructor
public class DashboardEnvDto {

    private Long id;

    /**
     * 环境名
     **/
    private String name;

    /**
     * 配置服务器
     */
    private List<ConfigServerInfo> configServers;

    /**
     * 项目数量
     */
    private Integer projects;

    /**
     * 环境参数数量
     */
    private Integer params;

}
