package com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Module;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.dao.ModuleMapper;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.CRUDModuleService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDModuleService
 * @author Code generator
 * @since 2022-02-17
 */

@Service
public class CRUDModuleServiceImpl  extends CRUDServiceOnlyImpl<Module> implements CRUDModuleService {





        @Resource
        protected ModuleMapper moduleMapper;

        @Override
        protected BaseMapper<Module> getMasterMapper() {
                return moduleMapper;
        }







}


