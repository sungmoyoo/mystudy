package com.yuil.dao.mysql;

import com.yuil.dao.OrderDao;
import com.yuil.vo.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrderDaoImpl implements OrderDao {


  Connection con;

  public OrderDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Order order) {
    try(Statement stmt = con.createStatement()) {
      stmt.executeUpdate(
          String.format(
              "insert into orders(product_name, count) values('%s', %d)",
              order.getProductName(), order.getCount()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }


  @Override
  public int delete(int no) {
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format("delete from orders where order_no = %d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }

  @Override
  public List<Order> findAll() {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery("""
          select
            o.order_no,
            o.count,
            o.ordered_date,
            i.classification,
            i.product_name,
            s.stock_no,
            s.stock,
            s.expiration_date
          from orders o
            join info i on o.product_name=i.product_name
            left outer join stocks s on i.product_no=s.product_no
          group by
            i.product_no
          order by
            o.order_no
          """);
      ArrayList<Order> list = new ArrayList<>();

      while (rs.next()) {
        Order order = new Order();
        order.setOrderNo(rs.getInt("order_no"));
        order.setCount(rs.getInt("count"));
        order.setOrderDate(rs.getDate("ordered_date"));
        order.setClassification(rs.getString("classification"));
        order.setProductName(rs.getString("product_name"));
        order.setStockNo(rs.getInt("stock_no"));
        order.setStock(rs.getInt("total_stock"));
        order.setExpirationDate(rs.getDate("expiration_date"));
        list.add(order);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Order findBy(int no) {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(String.format("""
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
            left outer join stocks s on i.product_no=s.product_no
          where
            o.order_no=%d
          group by
            i.product_no
          order by
            o.order_no
          """, no));

      Order order = new Order();

      if (rs.next()) {
        order.setOrderNo(rs.getInt("order_no"));
        order.setCount(rs.getInt("count"));
        order.setOrderDate(rs.getDate("ordered_date"));
        order.setClassification(rs.getString("classification"));
        order.setProductName(rs.getString("product_name"));
        order.setStock(rs.getInt("stock"));

        return order;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Order order) {
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format(
          "update orders set classification='%s', product='%s', count='%s' where order_no=%d",
          order.getClassification(), order.getProductName(), order.getCount(), order.getOrderNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }
}