package bitcamp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool implements ConnectionPool {
  private String jdbcURL;
  private String username;
  private String password;
  // DB 커넥션 목록
  ArrayList<Connection> connections = new ArrayList<>();

  // 개별 스레드용 DB 커넥션 저장소
  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

  public DBConnectionPool(String jdbcURL, String username, String password) {
    this.jdbcURL = jdbcURL;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws Exception{
    // 현재 스레드에 보관중인 Connection 객체를 꺼낸다.
    Connection con = connectionThreadLocal.get();


    if (con == null) {
      // 스레드에 보관된 Connection이 없다면,

      if (connections.size() > 0) {
        // 스레드풀에 놀고 있는 Connection이 있다면,
        con = connections.remove(0);
        System.out.printf("%s: DB 커넥션풀에서 꺼냄\n", Thread.currentThread().getName());

      } else {
        // 스레드풀에도 놀고 있는 Connection이 없다면,
        // 새로 Connection을 만든다.
        con = new ConnectionProxy(DriverManager.getConnection(jdbcURL, username, password), this);
        System.out.printf("%s: DB 커넥션 생성\n", Thread.currentThread().getName());
      }

      // 현재 스레드에서 Connection을 보관한다.
      connectionThreadLocal.set(con);

    } else {
      System.out.printf("%s: 스레드에 보관된 DB 커넥션 리턴\n", Thread.currentThread().getName());
    }
    return con;
  }

  public void returnConnection(Connection con) {
    // 현재 스레드에 보관중인 Connection 객체를 제거한다.
    connectionThreadLocal.remove();

    // Connection을 커넥션풀에 반납한다.
    connections.add(con);

    System.out.printf("%s: DB 커넥션을 커넥션풀에 반납\n", Thread.currentThread().getName());
  }

  public void closeAll() {
  for (Connection con : connections) {
    ((ConnectionProxy) con).realClose();
    }
  }
}