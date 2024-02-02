package com.yuil.dao;


import com.yuil.vo.Stock;
import java.util.List;

public interface StockDao {


  void add(Stock stock);

  int delete(int no);

  List<Stock> findAll();

  Stock findBy(int no);

  int update(Stock stock);

}
