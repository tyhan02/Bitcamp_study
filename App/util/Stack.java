package util;

public class Stack extends LinkedList{
    public void push(Object value){
        //목록 맨 끝에 추가
        // 따로 만들 필요 x
        // 슈퍼 클래스에 있는 메서드 이용해 기능 구현

        this.add(value); // 상속받은 메서드 = 서브 클래스에서 사용할 수 있는 슈퍼 클래스 메서드
    }

    public Object pop(){
        return null;
    }

}
