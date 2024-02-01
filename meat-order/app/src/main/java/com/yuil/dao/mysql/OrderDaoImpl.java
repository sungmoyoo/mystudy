package com.yuil.dao.mysql;

import com.yuil.dao.OrderDao;
import com.yuil.vo.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrderDaoImpl implements OrderDao {

  int category;
  Connection con;

  public OrderDaoImpl(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void add(Order order) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(
          String.format(
              "insert into boards(classification,product,gram) values('%d','%s','%s','%d')",
              order.getClassification(), order.getProduct(), order.getGram()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }


  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from boards where board_no = %d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }

  @Override
  public List<Order> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from boards where category=" + this.category);
      ArrayList<Order> list = new ArrayList<>();

      while (rs.next()) {

        Order order = new Order();
        order.setNo(rs.getInt("order_no"));
        order.setClassification(rs.getString("classification"));
        order.setProduct(rs.getString("product"));
        order.setGram(rs.getInt("gram"));
        order.setOrderDate(rs.getDate("created_date"));

        list.add(order);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public OrderDao findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from boards where board_no = " + no);

      OrderDao board = new OrderDao();

      if (rs.next()) {
        order.setNo(rs.getInt("board_no"));
        order.setTitle(rs.getString("classification"));
        order.setContent(rs.getString("product"));
        order.setWriter(rs.getString("gram"));
        order.setCreatedDate(rs.getDate("created_date"));
        return order;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override


  @Override
  public int update(OrderDao order) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update boards set title='%s', content='%s', writer='%s' where board_no=%d",
          order.getTitle(), order.getContent(), order.getWriter(), order.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }
}
