package com.yuil.dao;


import com.yuil.vo.Product;
import java.util.List;

public interface StockDao {


  void add(Product stock);

  int delete(int no);

  List<Product> findAll();

  Product findBy(int no);

  int update(Product stock);

}
