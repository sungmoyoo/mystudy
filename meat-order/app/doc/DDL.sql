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




insert into info(classification,product_name)
  values('소고기','LA갈비세트');
insert into info(classification,product_name)
  values('소고기','꽃등심');
insert into info(classification,product_name)
  values('소고기','채끝');
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

insert into orders(order_no,product_name,count)
  values(1,'LA갈비세트', 1);
insert into orders(product_name,count)
  values('LA갈비세트', 1);
insert into orders(product_name,count)
  values('꽃등심', 1);
insert into orders(product_name,count)
  values('삼겹살', 1);
insert into orders(product_name,count)
  values('항정살', 1);
insert into orders(product_name,count)
  values('프렌치랙', 1);
insert into orders(product_name,count)
  values('양꼬치엔칭따오', 1);

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

SELECT
  o.order_no,
  o.count,
  o.ordered_date,
  i.classification,
  i.product_name,
  s.stock,
  s.expiration_date
FROM
  orders o
JOIN
  info i ON o.product_name = i.product_name
LEFT OUTER JOIN
  stocks s ON i.product_no = s.product_no
WHERE
  (s.product_no, s.expiration_date) IN (
    SELECT
      product_no,
      MIN(expiration_date) AS exp_date
    FROM
      stocks
    GROUP BY
      product_no
  )
ORDER BY
  i.classification, s.expiration_date;

select
  o.order_no,
  o.count,
  o.ordered_date,
  i.classification,
  i.product_name,
  s.stock,
  s.expiration_date
from orders o
  join info i on o.product_name=i.product_name
  left outer join all stocks s on i.product_no=s.product_no
where order_no=%d
order by
  i.classification, s.expiration_date;