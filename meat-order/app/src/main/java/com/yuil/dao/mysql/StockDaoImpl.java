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
    try(Statement stmt = con.createStatement()) {
      stmt.executeUpdate(
          String.format(
              "insert into stocks(product_no,stock,expiration_date) values(%d,%d,'%s')",
              stock.getProductNo(), stock.getStock(),stock.getExpirationDate()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }


  @Override
  public int delete(int no) {
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format("delete from stocks where stock_no = %d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }

  @Override
  public List<Stock> findAll() {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery("""
              select
                s.product_no,
                s.stock_no,
                s.stock,
                s.expiration_date,
                i.classification,
                i.product_name
              from stocks s
                left outer join info i on s.product_no=i.product_no
              order by
              s.stock_no;""");
      ArrayList<Stock> list = new ArrayList<>();

      while (rs.next()) {

        Stock stock = new Stock();
        stock.setProductNo(rs.getInt("product_no"));
        stock.setStockNo(rs.getInt("stock_no"));
        stock.setStock(rs.getInt("stock"));
        stock.setExpirationDate(rs.getDate("expiration_date"));
        stock.setClassification(rs.getString("classification"));
        stock.setProductName(rs.getString("product_name"));

        list.add(stock);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Stock findBy(int no) {
    try (Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(String.format("""
              select
                s.product_no,
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
              """, no));

      Stock stock = new Stock();

      if (rs.next()) {
        stock.setProductNo(rs.getInt("product_no"));
        stock.setStockNo(rs.getInt("stock_no"));
        stock.setClassification(rs.getString("classification"));
        stock.setProductName(rs.getString("product_name"));
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
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format(
          "update stocks set stock_no=%d, product_no=%d, expiration_date='%s', stock=%d where stock_no=%d",
          stock.getStockNo(),stock.getProductNo(), stock.getExpirationDate(), stock.getStock(), stock.getStockNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }
}