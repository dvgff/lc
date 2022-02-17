package com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.model.Info;
import com.jfeat.module.lc_module.Asian.services.gen.persistence.dao.InfoMapper;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.CRUDInfoService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDInfoService
 * @author Code generator
 * @since 2022-02-17
 */

@Service
public class CRUDInfoServiceImpl  extends CRUDServiceOnlyImpl<Info> implements CRUDInfoService {





        @Resource
        protected InfoMapper infoMapper;

        @Override
        protected BaseMapper<Info> getMasterMapper() {
                return infoMapper;
        }







}


