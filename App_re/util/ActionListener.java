package util;

// caller: Memo
// callee: 메뉴를 처리할 객체
//
public interface ActionListener {

    // 사용자가 메뉴를 선택할 했을 때 호출된다.
    void service(BPrompt prompt);
}