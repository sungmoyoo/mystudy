package com.yuil.dao.mysql;

import com.yuil.dao.InfoDao;
import com.yuil.vo.Member;
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
  public void add(Member info) {
    try(Statement stmt = con.createStatement()) {
      stmt.executeUpdate(
          String.format(
              "insert into info(classification,product_name) values('%s','%s')",
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
  public List<Member> findAll() {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery("select * from info");
      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {

        Member info = new Member();
        info.setProductNo(rs.getInt("product_no"));
        info.setProductName(rs.getString("product_name"));
        info.setClassification(rs.getString("classification"));
        list.add(info);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public List<Member> findJoin() {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery("""
          select
            i.product_no,
            i.product_name,
            i.classification,
            s.stock
          from info i
            join stocks s on i.product_no=s.product_no
          group by
            product_no
          order by
            product_no
          
          """);
      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {

        Member info = new Member();
        info.setProductNo(rs.getInt("product_no"));
        info.setProductName(rs.getString("product_name"));
        info.setClassification(rs.getString("classification"));
        info.setStock(rs.getInt("stock"));
        list.add(info);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try(Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery("select * from info where product_no = " + no);

      Member info = new Member();

      if (rs.next()) {
        info.setProductNo(rs.getInt("product_no"));
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
  public int update(Member info) {
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format(
          "update info set classification='%s', product_name='%s' where info_no=%d",
          info.getClassification(), info.getProductName()));
    } catch (Exception e) {
      throw new DaoException("데이터 수정 오류", e);
    }
  }
}