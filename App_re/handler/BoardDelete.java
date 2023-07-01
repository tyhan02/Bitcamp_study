package handler;


import util.BPrompt;
import vo.Price;

import java.util.List;


public class BoardDelete extends AbstractBoard {

    public BoardDelete(List<Price> list) {
        super(list);
    }

    @Override
    public void service(BPrompt prompt) {
        if (!this.list.remove(new Price(prompt.inputInt("번호? ")))) {
            System.out.println("해당 번호의 게시글이 없습니다!");
        }
    }
}
