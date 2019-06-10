package org.typroject.tycloud.server.configadmin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.typroject.tyboot.core.restful.doc.TycloudOperation;
import org.typroject.tyboot.core.restful.doc.TycloudResource;
import org.typroject.tyboot.core.restful.utils.APILevel;
import org.typroject.tyboot.core.restful.utils.ResponseHelper;
import org.typroject.tyboot.core.restful.utils.ResponseModel;
import org.typroject.tycloud.server.configadmin.face.model.ConfigEncryptkeyModel;
import org.typroject.tycloud.server.configadmin.face.service.ConfigEncryptkeyService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 需要加密的key 前端控制器
 * </p>
 *
 * @author 子杨
 * @since 2019-05-22
 */

@RestController
@TycloudResource(module = "${package.ModuleName}", value = "configEncryptkey")
@RequestMapping(value = "/v1/${package.ModuleName}/ConfigEncryptkey")
@Api(value = "${package.ModuleName}-需要加密的key")
public class ConfigEncryptkeyResource {

    private final Logger logger = LogManager.getLogger(ConfigEncryptkeyResource.class);
    @Autowired
    private ConfigEncryptkeyService simpleService;


    @ApiOperation("List EncryptKey / 需加密的Key清单")
    @RequestMapping(method = RequestMethod.GET)
    public WebResp<List<EncryptKeyDto>> findAll() {

        List<EncryptKeyDto> result = new ArrayList<>();
        for (EncryptKey encryptKey : encryptKeyRepo.findAll()) {
            EncryptKeyDto dto = new EncryptKeyDto();
            BeanUtils.copyProperties(encryptKey, dto);
            result.add(dto);
        }

        return WebResp.success(result);
    }

    @ApiOperation("Add EncryptKey / 新增需加密的Key")
    @RequestMapping(method = RequestMethod.POST)
    public WebResp<String> createEncryptKey(@RequestBody EncryptKeyDto encryptKey) {
        log.info("add EncryptKey : " + encryptKey);

        EncryptKey saveEncryptKey = new EncryptKey();
        BeanUtils.copyProperties(encryptKey, saveEncryptKey);
        encryptKeyRepo.save(saveEncryptKey);

        return WebResp.success("add EncryptKey success");
    }

    @ApiOperation("Delete EncryptKey / 删除需加密的Key")
    @RequestMapping(method = RequestMethod.DELETE)
    public WebResp<String> deleteEncryptKey(@RequestParam("encryptKeyId") Long encryptKeyId) {
        EncryptKey encryptKey = encryptKeyRepo.findOne(encryptKeyId);

        log.info("delete EncryptKey : " + encryptKey);
        encryptKeyRepo.delete(encryptKeyId);

        return WebResp.success("delete EncryptKey [" + encryptKey.getEKey() + "] success");
    }

    @ApiOperation("Update EncryptKey / 更新需加密的Key")
    @RequestMapping(method = RequestMethod.PUT)
    public WebResp<String> updateEncryptKey(@RequestBody EncryptKeyDto encryptKey) {
        EncryptKey updateEncryptKey = encryptKeyRepo.findOne(encryptKey.getId());

        log.info("Update EncryptKey : " + updateEncryptKey + " --> " + encryptKey);

        updateEncryptKey.setEKey(encryptKey.getEKey());
        encryptKeyRepo.save(updateEncryptKey);

        return WebResp.success("update EncryptKey success");
    }

    /**
     * batch opt / 批量操作
     **/

    @Transactional
    @ApiOperation("Add EncryptKeys / 批量新增需加密的Key")
    @RequestMapping(path = "/batch", method = RequestMethod.POST)
    public WebResp<String> createBatch(@RequestBody List<EncryptKeyDto> encryptKeys) {
        log.info("Add EncryptKeys : " + encryptKeys);

        for (EncryptKeyDto encryptKey : encryptKeys) {
            EncryptKey saveEncryptKey = new EncryptKey();
            BeanUtils.copyProperties(encryptKey, saveEncryptKey);
            encryptKeyRepo.save(saveEncryptKey);
        }

        return WebResp.success("batch add EncryptKeys : " + encryptKeys.size());
    }

    @Transactional
    @ApiOperation("Delete EncryptKeys / 批量删除需加密的Key")
    @RequestMapping(path = "/batch", method = RequestMethod.DELETE)
    public WebResp<String> deleteBatch(@RequestBody List<Long> ids) {
        log.info("Delete EncryptKeys : " + ids);

        for (Long id : ids) {
            encryptKeyRepo.delete(id);
        }

        return WebResp.success("batch delete EncryptKeys ：" + ids.size());
    }


}
