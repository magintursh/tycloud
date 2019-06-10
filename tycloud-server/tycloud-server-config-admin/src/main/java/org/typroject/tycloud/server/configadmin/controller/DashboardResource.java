package org.typroject.tycloud.server.configadmin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.typroject.tyboot.core.restful.doc.TycloudOperation;
import org.typroject.tyboot.core.restful.doc.TycloudResource;
import org.typroject.tyboot.core.restful.utils.APILevel;
import org.typroject.tyboot.core.restful.utils.ResponseHelper;
import org.typroject.tyboot.core.restful.utils.ResponseModel;
import org.typroject.tycloud.server.configadmin.face.model.ConfigEnvModel;
import org.typroject.tycloud.server.configadmin.face.service.ConfigEnvService;

import java.util.List;


@RestController
@TycloudResource(module = "config", value = "dashboard")
@RequestMapping(value = "/v1/server/config/dashboard")
@Api(value = "config-环境属性")
public class DashboardResource  {

    @Autowired
    private ConfigEnvService configEnvService;

    @TycloudOperation(ApiLevel = APILevel.SUPERADMIN)
    @ApiOperation(value = "Env Summary / 环境总览信息")
    @RequestMapping(value = "/envSummary", method = RequestMethod.GET)
    public ResponseModel<List<ConfigEnvModel>> envSummaryInfo() throws Exception {
        return ResponseHelper.buildResponse(configEnvService.queryForDashboard());
    }

}
