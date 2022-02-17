package com.jfeat.module.lc_module.Asian.services.domain.service.impl;
import com.jfeat.module.lc_module.Asian.services.domain.service.PropertyService;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl.CRUDPropertyServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("propertyService")
public class PropertyServiceImpl extends CRUDPropertyServiceImpl implements PropertyService {

    @Override
    protected String entityName() {
        return "Property";
    }


                            }
