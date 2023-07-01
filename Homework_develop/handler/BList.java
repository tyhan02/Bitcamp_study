package handler;

import java.util.Iterator;
import java.util.List;
import vo.Price;
import util.BPrompt;

public class BList extends AbstractBoardL {

  public BList(List<Price> list) {
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











