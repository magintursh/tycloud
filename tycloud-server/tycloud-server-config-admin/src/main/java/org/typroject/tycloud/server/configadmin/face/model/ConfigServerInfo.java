package org.typroject.tycloud.server.configadmin.face.model;


public class ConfigServerInfo {

    /**
     * 配置中心操作接口的基础访问url
     */
    private String url;

    /**
     * 配置中心的加密功能状态
     */
    private String encryptStatus;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEncryptStatus() {
        return encryptStatus;
    }

    public void setEncryptStatus(String encryptStatus) {
        this.encryptStatus = encryptStatus;
    }
}
