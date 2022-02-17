package com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Property;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.dao.PropertyMapper;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.CRUDPropertyService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDPropertyService
 * @author Code generator
 * @since 2022-02-17
 */

@Service
public class CRUDPropertyServiceImpl  extends CRUDServiceOnlyImpl<Property> implements CRUDPropertyService {





        @Resource
        protected PropertyMapper propertyMapper;

        @Override
        protected BaseMapper<Property> getMasterMapper() {
                return propertyMapper;
        }







}


