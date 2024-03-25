package bitcamp.myapp.service;

import bitcamp.myapp.vo.Member;
import java.util.List;

public interface MemberService {

  void add(Member member);

  Member get(int no);

  Member get(String email, String password);

  List<Member> list();

  int update(Member member);

  int delete(int no);


}
