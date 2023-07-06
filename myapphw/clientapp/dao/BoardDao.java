package clientapp.dao;

import java.util.List;
import clientapp.vo.Board;

public interface BoardDao extends List<Board> {
    void insert(Board board);
    List<Board> list();
    Board findBy(int no);
    int update(Board board);
    int delete(int no);
}