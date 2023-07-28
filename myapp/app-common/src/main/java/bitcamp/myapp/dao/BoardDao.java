package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Board;

import java.util.List;

public interface BoardDao {
  void insert(Board board);
  List<Board> findAll();
  Board findBy(int no);
  int update(Board board);
  int updateCount(Board board);
  int delete(Board board);
}
