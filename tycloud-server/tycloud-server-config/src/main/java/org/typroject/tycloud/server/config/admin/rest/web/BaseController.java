package org.typroject.tycloud.server.config.admin.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.typroject.tycloud.server.config.admin.core.config.SccaProperties;
import org.typroject.tycloud.server.config.admin.core.domain.*;
import org.typroject.tycloud.server.config.admin.core.service.BaseOptService;
import org.typroject.tycloud.server.config.admin.core.service.PersistenceService;
import org.typroject.tycloud.server.config.admin.core.service.PropertiesService;
import org.typroject.tycloud.server.config.admin.core.service.UrlMakerService;
import org.typroject.tycloud.server.config.admin.rest.service.PermissionService;
import org.typroject.tycloud.server.config.admin.rest.service.UserService;

/**
 * Created by 程序猿DD/翟永超 on 2018/4/27.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
public class BaseController {

    @Autowired
    protected SccaProperties sccaProperties;

    @Autowired
    protected EnvRepo envRepo;
    @Autowired
    protected EnvParamRepo envParamRepo;
    @Autowired
    protected EncryptKeyRepo encryptKeyRepo;
    @Autowired
    protected ProjectRepo projectRepo;
    @Autowired
    protected LabelRepo labelRepo;

    @Autowired
    protected BaseOptService baseOptService;
    @Autowired
    protected PersistenceService persistenceService;
    @Autowired
    protected PropertiesService propertiesService;
    @Autowired
    protected UrlMakerService urlMakerService;

    @Autowired
    protected UserService userService;
    @Autowired
    protected PermissionService permissionService;

}
