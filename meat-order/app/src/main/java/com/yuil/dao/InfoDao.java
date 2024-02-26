package com.yuil.dao;


import com.yuil.vo.Member;
import java.util.List;

public interface InfoDao {


  void add(Member info);

  int delete(int no);

  List<Member> findAll();

  Member findBy(int no);

  int update(Member info);

  List<Member> findJoin();
}
