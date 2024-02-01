package com.yuil.dao;


import com.yuil.vo.Order;
import java.util.List;

public interface OrderDao {


  void add(Order order);

  int delete(int no);

  List<Order> findAll();

  Order findBy(int no);

  int update(Order order);

}
