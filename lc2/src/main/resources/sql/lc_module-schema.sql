SET FOREIGN_KEY_CHECKS=0;


create table lc_module
(
    id          bigint auto_increment
        primary key,
    module_name varchar(200) null comment '模块名称',
    property_id bigint       null comment '属性id',
        unique (id)
);
