package org.typroject.tycloud.api.privilege.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.typroject.tycloud.api.privilege.face.model.RoleMenuModel;
import org.typroject.tycloud.api.privilege.face.service.RoleMenuService;
import org.typroject.tyboot.core.foundation.context.RequestContext;
import org.typroject.tyboot.core.restful.doc.TycloudOperation;
import org.typroject.tyboot.core.restful.doc.TycloudResource;
import org.typroject.tyboot.core.restful.utils.APILevel;
import org.typroject.tyboot.core.restful.utils.ResponseHelper;
import org.typroject.tyboot.core.restful.utils.ResponseModel;

import java.util.List;

/**
 * <p>
 * 角色与菜单关系表 前端控制器
 * </p>
 *
 * @author magintursh
 * @since 2017-08-18
 */

@TycloudResource(module = "privilege",value = "rolemenu")
@RequestMapping(value = "/v1/privilege/rolemenu")
@Api(value = "privilege-角色菜单")
@RestController
public class RoleMenuResource {



    @Autowired
    RoleMenuService roleMenuService;






    @TycloudOperation( ApiLevel = APILevel.AGENCY)
    @ApiOperation(value="更新角色菜单权限")
    @RequestMapping(value = "/role/{sequenceNBR}", method = RequestMethod.PUT)
    public ResponseModel<List<RoleMenuModel>> updateByRole(@PathVariable Long sequenceNBR, @RequestBody String [] menuIds) throws Exception
    {
        return ResponseHelper.buildRespons(this.roleMenuService.updateByRole(menuIds,sequenceNBR, RequestContext.getAgencyCode()));
    }



}
