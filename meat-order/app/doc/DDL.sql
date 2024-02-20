
drop table if exists category restrict;
drop table if exists classification restrict;
drop table if exists product restrict;
drop table if exists product_image restrict;
drop table if exists members restrict;
drop table if exists users restrict;
drop table if exists sellers restrict;
drop table if exists orders restrict;
drop table if exists order_list restrict;

create table category (
  category_no int primary key auto_increment,
  category_name varchar(50) not null
);

create table classification (
  cls_no int primary key auto_increment,
  cls_name varchar(50) not null,
  category_no int not null
);

create table products (
  product_no int primary key auto_increment,
  seller_no int not null,
  cls_no int not null,
  product_name varchar(50) not null,
  product_des varchar(255) default null,
  product_price int not null,
  product_gram int not null,
  product_stock int not null,
  reg_date datetime null default now()
);

create table product_images (
  image_no int primary key auto_increment,
  image_path varchar(255) not null,
  product_no int not null
);

create table members (
  member_no int primary key auto_increment,
  id varchar(16) not null,
  pw varchar(16) not null,
  email varchar(30) not null,
  phone varchar(15) not null,
  sign_date datetime null default now()
);

create table users (
  user_no int primary key auto_increment,
  nickname varchar(30) default 'user',
  post_no varchar(10) not null,
  default_address varchar(255) not null,
  detail_address varchar(255) not null
);

create table sellers (
  seller_no int primary key auto_increment,
  store_name varchar(30) not null
);

create table orders (
  order_no int primary key auto_increment,
  user_no int not null,
  ordered_date datetime null default now(),
  order_request varchar(255) not null
);

create table order_list (
  order_no int not null,
  product_no int not null,
  primary key (order_no, product_no),
  order_cnt int not null,
  order_price int not null,
  star int check (star >= 1 and star <= 5),
  review varchar(255) not null
);


alter table classification
  add constraint cls_fk foreign key (category_no) references category(category_no);

alter table product_images
    add constraint images_fk foreign key (product_no) references products(product_no);

alter table members
  add constraint member_id_uk unique (id, email, phone);

alter table users
  add constraint user_no_fk foreign key (user_no) references members(member_no),
  add constraint nickname_uk unique (nickname);

alter table sellers
  add constraint seller_no_fk foreign key (seller_no) references members(member_no);

alter table products
  add constraint product_cls_fk foreign key (cls_no) references classification(cls_no),
  add constraint product_seller_fk foreign key (seller_no) references sellers(seller_no);

alter table orders
  add constraint user_fk foreign key (user_no) references users(user_no);

alter table order_list
    add constraint order_list_fk foreign key (order_no) references orders(order_no),
    add constraint product_list_fk foreign key (product_no) references products(product_no);

