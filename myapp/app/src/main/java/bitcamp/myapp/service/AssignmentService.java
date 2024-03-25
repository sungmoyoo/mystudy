package bitcamp.myapp.service;

import bitcamp.myapp.vo.Assignment;
import java.util.List;

public interface AssignmentService {

  void add(Assignment assignment);

  Assignment get(int no);

  List<Assignment> list();

  int update(Assignment assignment);

  int delete(int no);
}
