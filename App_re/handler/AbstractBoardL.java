package handler;

import util.ActionL;
import vo.Price;

import java.util.List;


public abstract class AbstractBoardL implements ActionL {

    protected List<Price> list;

    public AbstractBoardL(List<Price> list) {
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