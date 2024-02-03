package com.yuil.dao.mysql;

import com.yuil.dao.InfoDao;
import com.yuil.vo.Info;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class InfoDaoImpl implements InfoDao {


  Connection con;

  public InfoDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Info info) {
    try(Statement stmt = con.createStatement()) {
      stmt.executeUpdate(
          String.format(
              "insert into info(classification,product) values('%s','%s')",
              info.getClassification(), info.getProductName()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }


  @Override
  public int delete(int no) {
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format("delete from info where product_no = %d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }

  @Override
  public List<Info> findAll() {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery("""
          select
            i.product_no,
            i.product_name,
            i.classification,
            sum(s.stock) as total_stock
          from info i
            join stocks s on i.product_no=s.product_no
          group by
            product_no
          order by
            product_no
          
          """);
      ArrayList<Info> list = new ArrayList<>();

      while (rs.next()) {

        Info info = new Info();
        info.setProductNo(rs.getInt("product_no"));
        info.setClassification(rs.getString("classification"));
        info.setProductName(rs.getString("product_name"));
        info.setStock(rs.getInt("total_stock"));
        list.add(info);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Info findBy(int no) {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery("select * from info where product_no = " + no);

      Info info = new Info();

      if (rs.next()) {
        info.setProductNo(rs.getInt("info_no"));
        info.setClassification(rs.getString("classification"));
        info.setProductName(rs.getString("product_name"));
        return info;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Info info) {
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format(
          "update info set classification='%s', product_name='%s' where info_no=%d",
          info.getClassification(), info.getProductName()));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }
}