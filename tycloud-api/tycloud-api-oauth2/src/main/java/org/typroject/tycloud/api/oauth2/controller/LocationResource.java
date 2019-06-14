package org.typroject.tycloud.api.oauth2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.typroject.tyboot.core.restful.doc.TycloudOperation;
import org.typroject.tyboot.core.restful.doc.TycloudResource;
import org.typroject.tyboot.core.restful.utils.APILevel;
import org.typroject.tyboot.core.restful.utils.ResponseHelper;
import org.typroject.tyboot.core.restful.utils.ResponseModel;


/**
 * Created by magintursh on 2017-05-03.
 */

@TycloudResource(module = "oauth",value = "userinfo")
@RequestMapping(path = "/v1/oauth/userinfo")
@Api(value = "oauth-用户信息")
@RestController
public class LocationResource {
    private final Logger logger = LogManager.getLogger(LocationResource.class);



    @TycloudOperation( ApiLevel = APILevel.ALL,needAuth = false)
    @ApiOperation(value="获取所有省份信息")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseModel me() throws Exception {
        return ResponseHelper.buildResponse("");
    }



}