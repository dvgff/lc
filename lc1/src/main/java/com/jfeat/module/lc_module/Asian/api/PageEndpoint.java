
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
import com.jfeat.module.lc_module.Asian.services.domain.dao.QueryPageDao;
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
import com.jfeat.module.lc_module.Asian.services.domain.model.PageRecord;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Page;

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
    @Api("Page")
            @RequestMapping("/api/crud/Asian/page/pages")
    public class PageEndpoint {

    @Resource
    PageService pageService;

    @Resource
    QueryPageDao queryPageDao;



    @BusinessLog(name = "Page", value = "create Page")
    @Permission(PagePermission.PAGE_NEW)
    @PostMapping
    @ApiOperation(value = "新建 Page",response = Page.class)
    public Tip createPage(@RequestBody Page entity){
        Integer affected=0;
        try{
                affected= pageService.createMaster(entity);
            }catch(DuplicateKeyException e){
             throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
}

    @Permission(PagePermission.PAGE_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 Page",response = Page.class)
    public Tip getPage(@PathVariable Long id){
                        return SuccessTip.create(pageService.queryMasterModel(queryPageDao, id));
            }

    @BusinessLog(name = "Page", value = "update Page")
    @Permission(PagePermission.PAGE_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 Page",response = Page.class)
    public Tip updatePage(@PathVariable Long id,@RequestBody Page entity){
        entity.setId(id);
                return SuccessTip.create(pageService.updateMaster(entity));
            }

    @BusinessLog(name = "Page", value = "delete Page")
    @Permission(PagePermission.PAGE_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 Page")
    public Tip deletePage(@PathVariable Long id){
            return SuccessTip.create(pageService.deleteMaster(id));
        }

    @Permission(PagePermission.PAGE_VIEW)
    @ApiOperation(value = "Page 列表信息",response = PageRecord.class)
    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                            @ApiImplicitParam(name = "pageName", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "moduleId", dataType = "Integer") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
    public Tip queryPagePage(Page<PageRecord> page,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
    // for tag feature query
    @RequestParam(name = "tag" , required = false)String tag,
    // end tag
    @RequestParam(name = "search", required = false) String search,
                                                                                                                                        
                                                                                                                                    @RequestParam(name = "pageName", required = false) String pageName,
                    
                                                                                                                                            @RequestParam(name = "moduleId", required = false) Integer moduleId,
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

    PageRecord record = new PageRecord();
                                                                                                                                                                                                record.setPageName(pageName);
                                                                                                                        record.setModuleId(moduleId);
                        
                                

    List<PageRecord> pagePage = queryPageDao.findPagePage(page, record, tag, search, orderBy, null, null);

        
        page.setRecords(pagePage);

        return SuccessTip.create(page);
    }
}

