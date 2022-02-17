SET FOREIGN_KEY_CHECKS=0;


create table lc_property
(
    id             int auto_increment
        primary key,
    property_value varchar(200) null comment '属性名称',
        unique (id)
);