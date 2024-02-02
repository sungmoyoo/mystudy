create table products (
  product_id int primary key auto_increment,
  classification varchar(30) not null,
  product_name varchar(30) not null
);

create table orders (
  order_no int primary key auto_increment,
  product_id int not null,
  count int not null,
  ordered_date datetime null default now(),
  foreign key (product_id) references products(product_id)
);

create table stocks (
  stock_no int primary key auto_increment,
  product_id int not null,
  stock int not null,
  expiration_date datetime null default now(),
  foreign key (product_id) references products(product_id)
);

insert into orders(order_no,classification,product,count)
  values(1, '소고기', 'LA갈비세트', 1);
insert into orders(order_no,classification,product,count)
  values(2, '돼지고기', '삼겹살', 1);
insert into orders(order_no,classification,product,count)
  values(3, '양고기', '프렌치랙', 1);
insert into orders(order_no,classification,product,count)
  values(4, '닭고기', '닭가슴살', 1);



insert into stocks(stock_no,classification,product,stock)
  values(1, '소고기', 'LA갈비세트', 10);
insert into stocks(stock_no,classification,product,stock)
  values(2, '돼지고기', '삼겹살', 10);
insert into stocks(stock_no,classification,product,stock)
  values(3, '양고기', '프렌치랙', 10);
insert into stocks(stock_no,classification,product,stock)
  values(4, '닭고기', '닭가슴살', 10);