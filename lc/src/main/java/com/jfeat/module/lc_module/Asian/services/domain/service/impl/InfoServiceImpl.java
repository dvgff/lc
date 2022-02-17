package com.jfeat.module.lc_module.Asian.services.domain.service.impl;
import com.jfeat.module.lc_module.Asian.services.domain.service.InfoService;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl.CRUDInfoServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("infoService")
public class InfoServiceImpl extends CRUDInfoServiceImpl implements InfoService {

    @Override
    protected String entityName() {
        return "Info";
    }


                            }
