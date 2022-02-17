
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
import com.jfeat.module.lc_module.Asian.services.domain.dao.QueryInfoDao;
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
import com.jfeat.module.lc_module.Asian.services.domain.model.InfoRecord;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Info;

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
    @Api("Info")
            @RequestMapping("/api/crud/Asian/info/infos")
    public class InfoEndpoint {

    @Resource
    InfoService infoService;

    @Resource
    QueryInfoDao queryInfoDao;



    @BusinessLog(name = "Info", value = "create Info")
    @Permission(InfoPermission.INFO_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Info",response = Info.class)
    public Tip createInfo(@RequestBody Info entity){
        Integer affected=0;
        try{
                affected= infoService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(InfoPermission.INFO_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Info",response = Info.class)
    public Tip getInfo(@PathVariable Long id){
                        return SuccessTip.create(infoService.queryMasterModel(queryInfoDao, id));
            }

    @BusinessLog(name = "Info", value = "update Info")
    @Permission(InfoPermission.INFO_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Info",response = Info.class)
    public Tip updateInfo(@PathVariable Long id,@RequestBody Info entity){
        entity.setId(id);
                return SuccessTip.create(infoService.updateMaster(entity));
            }

    @BusinessLog(name = "Info", value = "delete Info")
    @Permission(InfoPermission.INFO_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Info")
    public Tip deleteInfo(@PathVariable Long id){
            return SuccessTip.create(infoService.deleteMaster(id));
        }

    @Permission(InfoPermission.INFO_VIEW)
    @ApiOperation(value = "Info 列表信息",response = InfoRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                    @ApiImplicitParam(name = "logo", dataType = "String") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryInfoPage(Page<InfoRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                            @RequestParam(name = "name", required = false) String name,
                    
                                                                                                                            @RequestParam(name = "logo", required = false) String logo,
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

    InfoRecord record = new InfoRecord();
                                                                                                                                                                                        record.setName(name);
                                                                                                                record.setLogo(logo);
                        
                                

    List<InfoRecord> infoPage = queryInfoDao.findInfoPage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(infoPage);

        return SuccessTip.create(page);
    }
}

