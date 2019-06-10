package org.typroject.tycloud.server.configadmin.face.model;

import org.typroject.tyboot.core.rdbms.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 环境
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */
public class ConfigEnvModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    private long id;
    /**
     * 环境名
     */
    private String name;
    /**
     * 注册中心地址，如果为空，配置中心的访问地址不使用服务名 registry_Address
     */
    private String registryAddress;
    /**
     * 配置中心的访问地址（比如：http://localhost:8888/）或服务名（配置服务名的时候需要与服务发现组件配合使用）
     */
    private String configServerName;
    /**
     * 如果配置中心设置了contextPath，那么也需要维护进来
     */
    private String contextPath;

    private List<ConfigEnvparamModel> envParams = new ArrayList<>();


    private List<ConfigProjectModel> projectModels = new ArrayList<>();


    private Integer projects;
    private Integer params;


    public Integer getProjects() {
        return projects;
    }

    public void setProjects(Integer projects) {
        this.projects = projects;
    }

    public Integer getParams() {
        return params;
    }

    public void setParams(Integer params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ConfigEnvparamModel> getEnvParams() {
        return envParams;
    }

    public void setEnvParams(List<ConfigEnvparamModel> envParams) {
        this.envParams = envParams;
    }


    public List<ConfigProjectModel> getProjectModels() {
        return projectModels;
    }

    public void setProjectModels(List<ConfigProjectModel> projectModels) {
        this.projectModels = projectModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public String getConfigServerName() {
        return configServerName;
    }

    public void setConfigServerName(String configServerName) {
        this.configServerName = configServerName;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

}
