package handler;

import java.util.List;
import util.BPrompt;
import vo.Price;

import java.util.Iterator;
public class BoardList extends AbstractBoard {

    public BoardList(List<Price> list) {
        super(list);
    }

    @Override
    public void service(BPrompt prompt) {
        System.out.println("---------------------------------------");
        System.out.println("번호, 제목, 작성자, 조회수, 등록일");
        System.out.println("---------------------------------------");

        Iterator<Price> iterator = list.iterator();

        while (iterator.hasNext()) {
            Price price = iterator.next();
            System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n",
                    price.getNo(),
                    price.getTitle(),
                    price.getWriter(),
                    price.getViewCount(),
                    price.getCreatedDate());
        }
    }

}
