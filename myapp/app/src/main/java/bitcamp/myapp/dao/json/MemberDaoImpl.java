package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.util.List;

public class MemberDaoImpl extends AbstractDao<Member> implements MemberDao {

  private int lastKey;

  public MemberDaoImpl(String filepath) {
    super(filepath);

    lastKey = list.getLast().getNo();
  }


  public int indexOf(int memberKey) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == memberKey) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public void add(Member member) {
    member.setNo(++lastKey);
    list.add(member);
    saveData();
  }

  @Override
  public int delete(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  public List<Member> findAll() {
    return list.subList(0, list.size());
  }

  @Override
  public Member findBy(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(int no, Member member) {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.set(index, member);
    saveData();
    return 1;
  }
}
