package handler;


import util.BPrompt;
import vo.Price;

import java.util.LinkedList;

public class BoardDetail extends AbstractBoard {

    public BoardDetail(LinkedList<Price> list) {
        super(list);
    }

    @Override
    public void service(BPrompt prompt) {
        int boardNo = prompt.inputInt("번호? ");

        Price price = this.findBy(boardNo);
        if (price == null) {
            System.out.println("해당 번호의 게시글이 없습니다!");
            return;
        }

        System.out.printf("제목: %s\n", price.getTitle());
        System.out.printf("내용: %s\n", price.getContent());
        System.out.printf("작성자: %s\n", price.getWriter());
        System.out.printf("조회수: %s\n", price.getViewCount());
        System.out.printf("등록일: %tY-%1$tm-%1$td\n", price.getCreatedDate());
        price.setViewCount(price.getViewCount() + 1);
    }
}


