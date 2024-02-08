# JDBC API와 JDBC Driver
**JDBC API**
자바에서 제공하는 인터페이스 및 클래스로 Driver 클래스
```
ex) java.sql.x, javax.sql.x
Driver
Connection
Statement
PrepareStatement
ResultSet
```

**JDBC Driver(.jar)**
vendor에서 제공하는 인터페이스 구현체 및 보조클래스
```
ex) MySQL Driver
com.mysql.cj.jdbc.Driver
com.mysql.cj.jdbc.ConnectionImpl
com.mysql.cj.jdbc.StatementImpl
...
```

# JDBC 프로그래밍
<그림>JDBC 구현체 간의 관계

## 1. JDBC 드라이버 준비(등록)

## 2. DBMS 연결

## 3. DBMS에 SQL문 보내기 

### 3.1 insert
### 3.2 select
### 3.3 update
### 3.4 delete





