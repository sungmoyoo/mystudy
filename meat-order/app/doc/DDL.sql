create table info (
  product_no int primary key auto_increment,
  classification varchar(30) not null,
  product_name varchar(30) not null
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
  product_no int not null,
  count int not null,
  ordered_date datetime null default now(),
  foreign key (stock_no) references info(stock_no)
);




insert into info(classification,product_name)
  values('소고기','LA갈비세트');
insert into info(classification,product_name)
  values('소고기','꽃등심');
insert into info(classification,product_name)
  values('소고기','[수입]채끝');
insert into info(classification,product_name)
  values('소고기','우삼겹');
insert into info(classification,product_name)
  values('돼지고기','삼겹살');
insert into info(classification,product_name)
  values('돼지고기','항정살');
insert into info(classification,product_name)
  values('돼지고기','다진고기');
insert into info(classification,product_name)
  values('닭고기','생닭');
insert into info(classification,product_name)
  values('닭고기','닭가슴살');
insert into info(classification,product_name)
  values('닭고기','윙봉');
insert into info(classification,product_name)
  values('양고기','양꼬치엔칭따오');
insert into info(classification,product_name)
  values('양고기','프렌치랙');

insert into stocks(product_no,expiration_date, stock)
  values(1,'2024-1-1', 10);
insert into stocks(product_no,expiration_date, stock)
  values(1,'2024-2-1', 10);
insert into stocks(product_no,expiration_date, stock)
  values(2,'2024-3-1', 10);
insert into stocks(product_no,expiration_date, stock)
  values(3,'2024-4-1', 10);
insert into stocks(product_no,expiration_date, stock)
  values(5,'2024-4-1', 10);
insert into stocks(product_no,expiration_date, stock)
  values(6,'2024-4-1', 10);

insert into orders(order_no,classification,product,count)
  values(1, '소고기', 'LA갈비세트', 1);
insert into orders(order_no,classification,product,count)
  values(2, '돼지고기', '삼겹살', 1);
insert into orders(order_no,classification,product,count)
  values(3, '양고기', '프렌치랙', 1);
insert into orders(order_no,classification,product,count)
  values(4, '닭고기', '닭가슴살', 1);


select
  s.stock_no,
  s.stock,
  s.expiration_date,
  i.classification,
  i.product_name
from stocks s
  left outer join info i on s.product_no=i.product_no
order by
s.stock_no;

select
  s.stock_no,
  s.stock,
  s.expiration_date,
  i.classification,
  i.product_name
from stocks s
  left outer join info i on s.product_no=i.product_no
where stock_no=%d
order by
s.stock_no;