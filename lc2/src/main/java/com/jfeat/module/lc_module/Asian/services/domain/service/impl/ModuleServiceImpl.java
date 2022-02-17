package com.jfeat.module.lc_module.Asian.services.domain.service.impl;
import com.jfeat.module.lc_module.Asian.services.domain.service.ModuleService;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl.CRUDModuleServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("moduleService")
public class ModuleServiceImpl extends CRUDModuleServiceImpl implements ModuleService {

    @Override
    protected String entityName() {
        return "Module";
    }


                            }
