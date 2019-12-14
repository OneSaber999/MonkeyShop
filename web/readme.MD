 git fetch --all && git reset --hard origin/master && git pull


drop table if exists `momkey_user`;

create table `monkey_user`(
	USER_ID varchar(32) not null,
	USER_NAME varchar(20) not null,
	USER_PASSWORD varchar(20) not null,
	USER_SEX varchar(1) not null,
	USER_BIRTHDAY datetime default null,
	USER_IDENTITY_CODE varchar(60) default null,
	USER_EMAIL varchar(60) default null,
	USER_MOBILE varchar(11) default null,
	USER_ADDRESS varchar(200) not null,
	USER_STATUS decimal(6,0) not null,
	USER_UPDATETIME timestamp not null default current_timestamp on update current_timestamp,
	primary key(`USER_ID`)
)ENGINE=InnoDB default charset=utf8;

drop table if exists `momkey_category`;

create table `monkey_category`(
	CATE_ID int(10) not null auto_increment,
	CATE_NAME varchar(20) not null,
	CATE_PARENT_ID decimal(10,0) not null,
	primary key(`CATE_ID`)
)ENGINE=InnoDB default charset=utf8;

drop table if exists `monkey_product`;

create table `monkey_product`(
	PRODUCT_ID int(10) not null auto_increment,
	PRODUCT_NAME varchar(128) not null,
	PRODUCT_DESCRIPTION varchar(512) default null,
	PRODUCT_PRICE decimal(10,2) not null,
	PRODUCT_STOCK decimal(10,0) default null,
	PRODUCT_FID decimal(10,0) default null,
	PRODUCT_CID decimal(10,0) default null,
	PRODUCT_FILENAME varchar(200) default null,
	primary key (`PRODUCT_ID`)	
)ENGINE=InnoDB default charset=utf8;

drop table if exists `monkey_cart`;

create table `monkey_cart`(
	CART_ID int(11) not null auto_increment,
	CART_P_FILENAME varchar(128) default null,
	CART_NAME varchar(64) default null,
	CART_P_PRICE decimal(10,2) not null,
	CART_QUANTITY int(11) default null,
	CART_P_STOCK int(11) default null,
	CART_P_ID int(11) default null,
	CART_U_ID varchar(64) default null,
	CART_VALID int(11) default null,
	
	primary key (`CART_ID`)	
)ENGINE=InnoDB default charset=utf8;


alter table monkey_user change USER_UPDATETIME USER_UPDATETIME timestamp not null 
default current_timestamp on update current_timestamp;

alter table monkey_user add USER_UPDATETIME timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

insert into MONKEY_USER (USER_ID,USER_NAME,USER_PASSWORD,USER_SEX,USER_BIRTHDAY,USER_IDENTITY_CODE,USER_EMAIL,USER_MOBILE,USER_ADDRESS,USER_STATUS) values('admin6','zz',123,'男','1998-02-02',null,'123@qq.com','12345678901','zzz',1);
