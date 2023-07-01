package util;

import java.util.ArrayList;

public class MemoGroup extends Memo {

    ArrayList<Memo> childs;

    public MemoGroup(String title) {
        super(title);
        this.childs = new ArrayList<>();
    }

    public void add(Memo memo) {
        this.childs.add(memo);
    }

    @Override
    public void execute(BPrompt prompt) {

        prompt.appendBreadcrumb(this.getTitle());

        this.printMenu();

        while (true) {
            String input = prompt.inputMenu();
            if (input.equals("menu")) {
                this.printMenu();
                continue;
            }

            int menuNo = Integer.parseInt(input);
            if (menuNo < 0 || menuNo > childs.size()) {
                System.out.println("메뉴 번호가 옳지 않습니다!");
            } else if (menuNo == 0) {
                prompt.removeBreadcrumb();
                return;
            } else {
                Memo memo = this.childs.get(menuNo - 1);
                memo.execute(prompt);
            }
        }
    }

    private void printMenu() {
        for (int i = 0; i < childs.size(); i++) {
            Memo memo = childs.get(i);
            System.out.printf("%d. %s\n", i + 1, memo.getTitle());
        }
        System.out.println("0. 이전/종료");
    }
}