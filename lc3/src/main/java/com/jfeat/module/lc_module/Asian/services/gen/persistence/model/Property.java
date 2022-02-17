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
@TableName("lc_property")
public class Property extends Model<Property> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 属性名称
     */
      private String propertyValue;

    
    public Integer getId() {
        return id;
    }

      public Property setId(Integer id) {
          this.id = id;
          return this;
      }
    
    public String getPropertyValue() {
        return propertyValue;
    }

      public Property setPropertyValue(String propertyValue) {
          this.propertyValue = propertyValue;
          return this;
      }

      public static final String ID = "id";

      public static final String PROPERTY_VALUE = "property_value";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "Property{" +
              "id=" + id +
                  ", propertyValue=" + propertyValue +
              "}";
    }
}
