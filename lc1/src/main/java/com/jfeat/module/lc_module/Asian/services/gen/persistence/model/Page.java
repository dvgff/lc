package com.jfeat.module.lc_module.Asian.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2022-02-17
 */
@TableName("lc_page")
public class Page extends Model<Page> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 页面名称
     */
      private String pageName;

      /**
     * 模块id
     */
      private Integer moduleId;

    
    public Long getId() {
        return id;
    }

      public Page setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getPageName() {
        return pageName;
    }

      public Page setPageName(String pageName) {
          this.pageName = pageName;
          return this;
      }
    
    public Integer getModuleId() {
        return moduleId;
    }

      public Page setModuleId(Integer moduleId) {
          this.moduleId = moduleId;
          return this;
      }

      public static final String ID = "id";

      public static final String PAGE_NAME = "page_name";

      public static final String MODULE_ID = "module_id";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "Page{" +
              "id=" + id +
                  ", pageName=" + pageName +
                  ", moduleId=" + moduleId +
              "}";
    }
}
