SET FOREIGN_KEY_CHECKS=0;


create table lc_page
(
    id        bigint auto_increment
        primary key,
    page_name varchar(200) null comment '页面名称',
    module_id int          null comment '模块id',
        unique (id)
);
