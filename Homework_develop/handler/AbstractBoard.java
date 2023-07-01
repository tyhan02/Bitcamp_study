package handler;

import java.util.List;
import vo.Price;
import util.ActionL;

public abstract class AbstractBoard implements ActionL {

  protected List<Price> list;

  public AbstractBoard(List<Price> list) {
    this.list = list;
  }

  protected Price findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Price b = this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

}
