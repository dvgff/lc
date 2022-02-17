package com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Page;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.dao.PageMapper;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.CRUDPageService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDPageService
 * @author Code generator
 * @since 2022-02-17
 */

@Service
public class CRUDPageServiceImpl  extends CRUDServiceOnlyImpl<Page> implements CRUDPageService {





        @Resource
        protected PageMapper pageMapper;

        @Override
        protected BaseMapper<Page> getMasterMapper() {
                return pageMapper;
        }







}


