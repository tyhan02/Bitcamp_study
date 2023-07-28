package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Member;

import java.util.List;

public interface MemberDao {
  void insert(Member member);
  List<Member> findAll();
  Member findBy(int no);
  Member findByEmailAndPassword(Member m);
  int update(Member member);
  int delete(int no);
}
