package com.yuil.dao;


import com.yuil.vo.User;
import java.util.List;

public interface OrderDao {


  void add(User order);

  int delete(int no);

  List<User> findAll();

  User findBy(int no);

  int update(User order);

}
