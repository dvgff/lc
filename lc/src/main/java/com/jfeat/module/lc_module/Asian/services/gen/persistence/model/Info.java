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
@TableName("app_info")
public class Info extends Model<Info> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String name;

    private String logo;

    
    public Long getId() {
        return id;
    }

      public Info setId(Long id) {
          this.id = id;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public Info setName(String name) {
          this.name = name;
          return this;
      }
    
    public String getLogo() {
        return logo;
    }

      public Info setLogo(String logo) {
          this.logo = logo;
          return this;
      }

      public static final String ID = "id";

      public static final String NAME = "name";

      public static final String LOGO = "logo";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "Info{" +
              "id=" + id +
                  ", name=" + name +
                  ", logo=" + logo +
              "}";
    }
}
