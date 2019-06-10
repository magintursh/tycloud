package org.typroject.tycloud.server.configadmin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.typroject.tyboot.core.restful.doc.TycloudOperation;
import org.typroject.tyboot.core.restful.doc.TycloudResource;
import org.typroject.tyboot.core.restful.utils.APILevel;
import org.typroject.tyboot.core.restful.utils.ResponseHelper;
import org.typroject.tyboot.core.restful.utils.ResponseModel;
import org.typroject.tycloud.server.configadmin.face.model.ConfigLabelModel;
import org.typroject.tycloud.server.configadmin.face.service.ConfigLabelService;

/**
 * <p>
 * 环境属性 前端控制器
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */

@RestController
@TycloudResource(module = "${package.ModuleName}", value = "configLabel")
@RequestMapping(value = "/v1/${package.ModuleName}/ConfigLabel")
@Api(value = "${package.ModuleName}-环境属性")
public class ConfigLabelResource {

    private final Logger logger = LogManager.getLogger(ConfigLabelResource.class);
    @Autowired
    private ConfigLabelService simpleService;


    @TycloudOperation(ApiLevel = APILevel.SUPERADMIN)
    @ApiOperation(value = "创建")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseModel<ConfigLabelModel> create(@RequestBody ConfigLabelModel model) throws Exception {
        model = simpleService.createWithModel(model);
        return ResponseHelper.buildResponse(model);
    }

    @TycloudOperation(ApiLevel = APILevel.SUPERADMIN)
    @ApiOperation(value = "更新")
    @RequestMapping(value = "/{sequenceNbr}", method = RequestMethod.PUT)
    public ResponseModel<ConfigLabelModel> update(
            @RequestBody ConfigLabelModel model,
            @PathVariable(value = "sequenceNbr") Long sequenceNbr) throws Exception {
        model.setSequenceNbr(sequenceNbr);
        return ResponseHelper.buildResponse(simpleService.updateWithModel(model));
    }

    @TycloudOperation(ApiLevel = APILevel.SUPERADMIN)
    @ApiOperation(value = "查询单个对象")
    @RequestMapping(value = "/{sequenceNbr}", method = RequestMethod.GET)
    public ResponseModel<ConfigLabelModel> seleteOne(@PathVariable Long sequenceNbr) throws Exception {
        return ResponseHelper.buildResponse(simpleService.queryBySeq(sequenceNbr));
    }


}
