package com.jfeat.module.lc_module.Asian.services.domain.dao;

import com.jfeat.module.lc_module.Asian.services.domain.model.InfoRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Info;
import com.jfeat.module.lc_module.Asian.services.gen.crud.model.InfoModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2022-02-17
 */
public interface QueryInfoDao extends QueryMasterDao<Info> {
   /*
    * Query entity list by page
    */
    List<InfoRecord> findInfoPage(Page<InfoRecord> page, @Param("record") InfoRecord record,
                                            @Param("tag") String tag,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    InfoModel queryMasterModel(@Param("id") Long id);


    /*
     * Query entity model list for slave items
     */
    List<InfoModel> queryMasterModelList(@Param("masterId") Object masterId);
}