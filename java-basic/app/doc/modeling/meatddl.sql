create table info (
  product_no int primary key auto_increment,
  classification varchar(30) not null,
  product_name varchar(30) not null unique
);

create table stocks (
  stock_no int primary key auto_increment,
  product_no int not null,
  stock int not null,
  expiration_date date not null,
  foreign key (product_no) references info(product_no)
);

create table orders (
  order_no int primary key auto_increment,
  product_name varchar(30) not null,
  count int not null,
  ordered_date datetime null default now(),
  foreign key (product_name) references info(product_name)
);