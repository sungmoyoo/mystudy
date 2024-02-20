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