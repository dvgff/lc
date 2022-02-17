
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
import com.jfeat.module.lc_module.Asian.services.domain.dao.QueryPropertyDao;
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
import com.jfeat.module.lc_module.Asian.services.domain.model.PropertyRecord;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Property;

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
    @Api("Property")
            @RequestMapping("/api/crud/Asian/property/propertyies")
    public class PropertyEndpoint {

    @Resource
    PropertyService propertyService;

    @Resource
    QueryPropertyDao queryPropertyDao;



    @BusinessLog(name = "Property", value = "create Property")
    @Permission(PropertyPermission.PROPERTY_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Property",response = Property.class)
    public Tip createProperty(@RequestBody Property entity){
        Integer affected=0;
        try{
                affected= propertyService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(PropertyPermission.PROPERTY_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Property",response = Property.class)
    public Tip getProperty(@PathVariable Long id){
                        return SuccessTip.create(propertyService.queryMasterModel(queryPropertyDao, id));
            }

    @BusinessLog(name = "Property", value = "update Property")
    @Permission(PropertyPermission.PROPERTY_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Property",response = Property.class)
    public Tip updateProperty(@PathVariable Long id,@RequestBody Property entity){
        entity.setId(id);
                return SuccessTip.create(propertyService.updateMaster(entity));
            }

    @BusinessLog(name = "Property", value = "delete Property")
    @Permission(PropertyPermission.PROPERTY_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Property")
    public Tip deleteProperty(@PathVariable Long id){
            return SuccessTip.create(propertyService.deleteMaster(id));
        }

    @Permission(PropertyPermission.PROPERTY_VIEW)
    @ApiOperation(value = "Property 列表信息",response = PropertyRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Integer"),
                                                                                            @ApiImplicitParam(name = "propertyValue", dataType = "String") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryPropertyPage(Page<PropertyRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                                    @RequestParam(name = "propertyValue", required = false) String propertyValue,
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

    PropertyRecord record = new PropertyRecord();
                                                                                                                                                                                                record.setPropertyValue(propertyValue);
                        
                                

    List<PropertyRecord> propertyPage = queryPropertyDao.findPropertyPage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(propertyPage);

        return SuccessTip.create(page);
    }
}

