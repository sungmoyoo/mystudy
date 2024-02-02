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
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(
          String.format(
              "insert into orders(classification,product,count) values('%s','%s','%d')",
              order.getClassification(), order.getProduct(), order.getCount()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }


  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from orders where order_no = %d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }

  @Override
  public List<Order> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from orders");
      ArrayList<Order> list = new ArrayList<>();

      while (rs.next()) {

        Order order = new Order();
        order.setNo(rs.getInt("order_no"));
        order.setClassification(rs.getString("classification"));
        order.setProduct(rs.getString("product"));
        order.setCount(rs.getInt("count"));
        order.setOrderDate(rs.getDate("ordered_date"));

        list.add(order);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Order findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from orders where order_no = " + no);

      Order order = new Order();

      if (rs.next()) {
        order.setNo(rs.getInt("order_no"));
        order.setClassification(rs.getString("classification"));
        order.setProduct(rs.getString("product"));
        order.setCount(rs.getInt("count"));
        order.setOrderDate(rs.getDate("ordered_date"));
        return order;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Order order) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update orders set classification='%s', product='%s', count='%s' where order_no=%d",
          order.getClassification(), order.getProduct(), order.getCount(), order.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }
}