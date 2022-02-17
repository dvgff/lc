package com.jfeat.module.lc_module.Asian.services.domain.service.impl;
import com.jfeat.module.lc_module.Asian.services.domain.service.PageService;
import com.jfeat.module.lc_module.Asian.services.gen.crud.service.impl.CRUDPageServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("pageService")
public class PageServiceImpl extends CRUDPageServiceImpl implements PageService {

    @Override
    protected String entityName() {
        return "Page";
    }


                            }
