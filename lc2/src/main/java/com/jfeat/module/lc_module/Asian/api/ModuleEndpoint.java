
package com.jfeat.module.lc_module.Asian.api;


import com.jfeat.crud.plus.META;
import com.jfeat.am.core.jwt.JWTKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.module.lc_module.Asian.services.domain.dao.QueryModuleDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.base.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.crud.plus.DefaultFilterResult;
import com.jfeat.module.lc_module.Asian.api.permission.*;
import com.jfeat.am.common.annotation.Permission;
import java.math.BigDecimal;

import com.jfeat.module.lc_module.Asian.services.domain.service.*;
import com.jfeat.module.lc_module.Asian.services.domain.model.ModuleRecord;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Module;

    import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
/**
 * <p>
 *  api
 * </p>
 *
 * @author Code generator
 * @since 2022-02-17
 */
    @RestController
    @Api("Module")
            @RequestMapping("/api/crud/Asian/module/modules")
    public class ModuleEndpoint {

    @Resource
    ModuleService moduleService;

    @Resource
    QueryModuleDao queryModuleDao;



    @BusinessLog(name = "Module", value = "create Module")
    @Permission(ModulePermission.MODULE_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Module",response = Module.class)
    public Tip createModule(@RequestBody Module entity){
        Integer affected=0;
        try{
                affected= moduleService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(ModulePermission.MODULE_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Module",response = Module.class)
    public Tip getModule(@PathVariable Long id){
                        return SuccessTip.create(moduleService.queryMasterModel(queryModuleDao, id));
            }

    @BusinessLog(name = "Module", value = "update Module")
    @Permission(ModulePermission.MODULE_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Module",response = Module.class)
    public Tip updateModule(@PathVariable Long id,@RequestBody Module entity){
        entity.setId(id);
                return SuccessTip.create(moduleService.updateMaster(entity));
            }

    @BusinessLog(name = "Module", value = "delete Module")
    @Permission(ModulePermission.MODULE_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Module")
    public Tip deleteModule(@PathVariable Long id){
            return SuccessTip.create(moduleService.deleteMaster(id));
        }

    @Permission(ModulePermission.MODULE_VIEW)
    @ApiOperation(value = "Module 列表信息",response = ModuleRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                            @ApiImplicitParam(name = "moduleName", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "propertyId", dataType = "Long") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryModulePage(Page<ModuleRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                                    @RequestParam(name = "moduleName", required = false) String moduleName,
                    
                                                                                                                                            @RequestParam(name = "propertyId", required = false) Long propertyId,
        @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
                    
            if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String pattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(pattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    ModuleRecord record = new ModuleRecord();
                                                                                                                                                                                                record.setModuleName(moduleName);
                                                                                                                        record.setPropertyId(propertyId);
                        
                                

    List<ModuleRecord> modulePage = queryModuleDao.findModulePage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(modulePage);

        return SuccessTip.create(page);
    }
}

