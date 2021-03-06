package org.typroject.tycloud.server.config.admin.core.domain;

import   org.typroject.tycloud.server.config.admin.core.domain.EnvParam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by 程序猿DD/翟永超 on 2018/4/24.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
public interface EnvParamRepo extends JpaRepository<EnvParam, Long> {

    List<EnvParam> findAllByEnv_Name(String envName);

    List<EnvParam> findAllByEnv_Id(Long id);

}
