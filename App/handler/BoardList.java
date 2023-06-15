package handler;

import util.Board;

public class BoardList {

    private static final int DEFALT_SIZE = 3;
    private Board[] boards = new Board[DEFALT_SIZE];
    private int length = 0;

    public boolean add(Board board) {
        if (this.length == boards.length) {
            increase();
        }
        this.boards[this.length++] = board;
    }

    private void increase() {
        //기존 배열 볻 50% 큰 배열을 새로 만듬
        Board[] arr = new Board[boards.length + (boards.length >> 1)];

        //기존 배열의 값을 새 배열로 복사한다
        for (int i = 0; i < boards.length; i++) {
            arr[i] = boards[i];
        }
        // boards 레퍼런스가 새 배열을 가리키도록 한다
        boards = arr;
      //  System.out.println("배열을 늘려!");
    }

    public Board[] list () {
        Board[] arr = new Board[this.length];

        for (int i = 0; i < this.length; i++) {
            arr[i] = this.boards[i];
        }
        return arr;
    }

    public Board get ( int no){
        for (int i = 0; i < this.length; i++) {
                    Board board = this.boards[i]
            if (board.getNo() == no) {
                return board;
                    }
                }
                return null;
            }

    public boolean delete ( int no){
         int deletedIndex = this.indexOf(no);
         if (deletedIndex == -1) {
                return false;
                }

    }

            private int indexOf ( int memberNo){
                for (int i = 0; i < this.length; i++) {
                    Board board = this.boards[i];
                    if (board.getNo() == memberNo) {
                        return i;
                    }
                }
                return -1;

            }

        }
    }
}