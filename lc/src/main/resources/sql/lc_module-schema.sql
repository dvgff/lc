SET FOREIGN_KEY_CHECKS=0;

create table app_info
(
    id   bigint auto_increment
        primary key,
    name varchar(200) not null,
    logo varchar(200) null,
        unique (id)
);
create table lc_page
(
    id        bigint auto_increment
        primary key,
    page_name varchar(200) null comment '页面名称',
    module_id int          null comment '模块id'
        unique (id)
);
create table lc_module
(
    id          bigint auto_increment
        primary key,
    module_name varchar(200) null comment '模块名称',
    property_id bigint       null comment '属性id',
        unique (id)
);
create table lc_property
(
    id             int auto_increment
        primary key,
    property_value varchar(200) null comment '属性名称',
        unique (id)
);