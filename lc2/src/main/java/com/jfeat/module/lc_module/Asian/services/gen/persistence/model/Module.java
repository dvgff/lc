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
@TableName("lc_module")
public class Module extends Model<Module> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 模块名称
     */
      private String moduleName;

      /**
     * 属性id
     */
      private Long propertyId;

    
    public Long getId() {
        return id;
    }

      public Module setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getModuleName() {
        return moduleName;
    }

      public Module setModuleName(String moduleName) {
          this.moduleName = moduleName;
          return this;
      }
    
    public Long getPropertyId() {
        return propertyId;
    }

      public Module setPropertyId(Long propertyId) {
          this.propertyId = propertyId;
          return this;
      }

      public static final String ID = "id";

      public static final String MODULE_NAME = "module_name";

      public static final String PROPERTY_ID = "property_id";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "Module{" +
              "id=" + id +
                  ", moduleName=" + moduleName +
                  ", propertyId=" + propertyId +
              "}";
    }
}
