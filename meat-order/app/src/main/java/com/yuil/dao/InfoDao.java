package com.yuil.dao;


import com.yuil.vo.Info;
import java.util.List;

public interface InfoDao {


  void add(Info info);

  int delete(int no);

  List<Info> findAll();

  Info findBy(int no);

  int update(Info info);

}
