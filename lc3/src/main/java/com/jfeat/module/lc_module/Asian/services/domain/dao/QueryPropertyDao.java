package com.jfeat.module.lc_module.Asian.services.domain.dao;

import com.jfeat.module.lc_module.Asian.services.domain.model.PropertyRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Property;
import com.jfeat.module.lc_module.Asian.services.gen.crud.model.PropertyModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-02-17
 */
public interface QueryPropertyDao extends QueryMasterDao<Property> {
   /*
    * Query entity list by page
    */
    List<PropertyRecord> findPropertyPage(Page<PropertyRecord> page, @Param("record") PropertyRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    PropertyModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<PropertyModel> queryMasterModelList(@Param("masterId") Object masterId);
}