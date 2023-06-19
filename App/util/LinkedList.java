package util;

public class LinkedList {
        Node tail;
    public static void add(Object value) {
        //1. 새 노드를 생성하기
        //2. 새 노드에 값 저장
        //3. 리스트의 마지막 노드에 새 노드를 연결
        Node node = new Node();
        node.value = value;

        if(tail!=null){

        }else{
            tail = node;
        }

        tail= node;
    }
}
