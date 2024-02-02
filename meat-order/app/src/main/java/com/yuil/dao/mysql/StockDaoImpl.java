package com.yuil.dao.mysql;

import com.yuil.dao.StockDao;
import com.yuil.vo.Stock;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StockDaoImpl implements StockDao {


  Connection con;

  public StockDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Stock stock) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(
          String.format(
              "insert into stocks(classification,product,stock) values('%s','%s','%d')",
              stock.getClassification(), stock.getProduct(), stock.getStock()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }


  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from stocks where stock_no = %d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }

  @Override
  public List<Stock> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from stocks");
      ArrayList<Stock> list = new ArrayList<>();

      while (rs.next()) {

        Stock stock = new Stock();
        stock.setNo(rs.getInt("stock_no"));
        stock.setClassification(rs.getString("classification"));
        stock.setProduct(rs.getString("product"));
        stock.setStock(rs.getInt("stock"));
        stock.setExpirationDate(rs.getDate("expiration_date"));

        list.add(stock);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Stock findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from stocks where stock_no = " + no);

      Stock stock = new Stock();

      if (rs.next()) {
        stock.setNo(rs.getInt("stock_no"));
        stock.setClassification(rs.getString("classification"));
        stock.setProduct(rs.getString("product"));
        stock.setStock(rs.getInt("stock"));
        stock.setExpirationDate(rs.getDate("expiration_date"));
        return stock;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Stock stock) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update stocks set classification='%s', product='%s', stock='%s' where stock_no=%d",
          stock.getClassification(), stock.getProduct(), stock.getStock(), stock.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }
}