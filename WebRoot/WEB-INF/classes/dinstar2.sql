--新建数据库
create database dinstar2 default character set utf8 collate utf8_general_ci;

--管理员信息表
create table admin(
adminId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
adminName varchar(255) not null unique comment '管理员名字',
adminPassword varchar(255) not null comment '密码',
adminPower int(11) not null comment '管理员权限'
);

insert into admin(adminName,adminPassword,adminPower) value("admin2","12345678","0");

--产品类别表
create table p_category(
categoryId int(11) NOT NULL AUTO_INCREMENT primary key comment '产品类别id',
categoryName varchar(255) not null unique comment '产品类别名称'
);


--产品表
create table p_product(
productId int(11) NOT NULL AUTO_INCREMENT primary key comment '产品id',
minImage varchar(255) not null default '' comment '产品缩略图',
imageList text not null comment '产品图片列表',
productName varchar(255) not null unique comment '产品名称',
categoryId int(11) not null comment '产品类别id',
summary text not null comment '概述',
description text not null comment '详细说明',
function text not null comment '功能描述',
model text not null comment '型号描述',
download text not null comment '下载地址'
);

--幻灯片定制表
create table slide(
slideId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
description varchar(255) not null default '' comment '说明',
imageUrl varchar(255) not null default '' comment '图片地址',
url varchar(255) not null default '' comment '跳转地址'
);


--友情链接定制表
create table partners(
partnersId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
description varchar(255) not null default '' comment '说明',
imageUrl varchar(255) not null default '' comment '图片地址',
url varchar(255) not null default '' comment '跳转地址',
dispalyNum int(11) not null comment '显示位置'
);

--文档中心分类表
create table doc_category(
categoryId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
categoryName varchar(255) not null unique comment '类别名称'
);

--文档中心
create table document(
documentId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
categoryId int(11) not null comment '类别id',
title varchar(255) null default '' comment '标题',
edition varchar(255) null default '' comment '版本',
download text not null comment '下载地址',
ctime timestamp not null default current_timestamp comment '发布时间',
flow int(11) not null default 1 comment '浏览次数'
);

--合作申请表
create table coop(
coopId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
name varchar(255) not null comment '姓名',
country varchar(255) not null comment '国家',
province varchar(255) not null comment '省份',
city varchar(255) not null comment '城市',
phone varchar(255) not null comment '电话',
email varchar(255) not null comment 'email',
company varchar(255) not null comment '公司名',
url varchar(255) not null comment '公司网址',
content text not null comment '更多信息'
);

--一级栏目表
create table one_columns(
columnsId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
columnName varchar(255) not null comment '栏目名称',
columnPosition int(11) not null comment '位置',
isDisplay int(11) not null default 1 comment '是否显示'
);
insert into one_columns(columnName,columnPosition) value("首页","1");

--二级栏目表
create table two_columns(
columnsId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
relationId int(11) not null comment '关联的一级栏目',
columnPosition int(11) not null comment '位置',
columnClass int(11) not null comment '栏目下资源类别',
columnName varchar(255) not null comment '栏目名称'
);

--文章表
create table t_text(
textId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
categoryId int(11) not null comment '文章类别id',
minImage varchar(255) not null default '' comment '缩略图',
title varchar(255) null default '' comment '文章标题',
edition varchar(255) null default '' comment '版本',
download text not null comment '下载地址',
summary text not null comment '概述',
ctime timestamp not null default current_timestamp comment '发布时间',
flow int(11) not null default 1 comment '浏览次数',
content text not null comment '文章内容'
);



--游客在线问答
create table user_question(
questionId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
userName varchar(255) not null comment '游客名字',
ctime timestamp not null default current_timestamp comment '发布时间',
email varchar(255) not null default '' comment 'email',
content text not null comment '内容'
);

create table admin_answer(
answerId int(11) NOT NULL AUTO_INCREMENT primary key comment 'id',
adminName varchar(255) not null comment '管理员名字',
questionId int(11) not null comment '问题id',
ctime timestamp not null default current_timestamp comment '发布时间',
content text not null comment '内容'
);

alter table t_text
add constraint fk_Text_Category
foreign key(categoryId) references two_columns(columnsId);

--设置表之间的关联或外键
alter table document
add constraint fk_Document_Category
foreign key(categoryId) references doc_category(categoryId);


alter table p_product
add constraint fk_Products_Category
foreign key(categoryId) references p_category(categoryId);

alter table admin_answer
add constraint fk_admin_answer
foreign key(questionId) references user_question(questionId);

alter table two_columns
add constraint fk_one_columns
foreign key(relationId) references one_columns(columnsId);
