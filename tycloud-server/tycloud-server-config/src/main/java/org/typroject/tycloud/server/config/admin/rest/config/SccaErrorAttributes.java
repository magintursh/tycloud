package org.typroject.tycloud.server.config.admin.rest.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class SccaErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> body = super.getErrorAttributes(webRequest, includeStackTrace);
        body.put("code", body.get("status"));
        body.remove("status");
        return body;
    }

}