package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Assignment;
import java.io.IOException;
import java.util.List;

public interface AssignmentDao {

  void add(Assignment assignment) throws IOException;

  int delete(int no);

  List<Assignment> findAll();

  Assignment findBy(int no);

  int update(Assignment assignment);

}
