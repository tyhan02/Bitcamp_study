package Test_0609.step15;

import Test_0609.step15.vo.Score;// 2) 낱개의 변수 재사용
// 3) 배열 사용
// 4) 클래스를 이용하여 데이터 타입 정의(중첩클래스; 로컬 클래스)
// 5) 출력 기능을 별도의 메서드로 분리(중첩클래스; 스태틱 중첩 클래스)
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) GRASP 패턴: Information Experts(정보를 가지고 있는 클래스가 그 정보를 다뤄야 한다)
// 8) 인스턴스 메서드 도입 (절대 class 이름으로 호출 불가)
// 9) 객체 생성이 복잡한 경우 메서드로 분리하는 것이 낫다(디자인 패턴: factory method)
// 10) GRASP 패턴: Information Experts
//      -createScore()를 score 클래스로 이동
// 11) 생성자 도입; 인스턴스 변수를 보다 쉽게 초기화 시키기
// 12) 클래스를 유지보수 하기 쉽게 별도 소스 파일로 분리
// 13) 클래스를 유지보수 하기 쉽게 패키지로 분류: import, public
// 14) 외부접근 차단과 값 꺼내기 private, getter
// 15) 프로그래밍이 일관성을 위해 보통 다른 필드에 대해서도 getter를 만들고 사용

public class Test {

    public static void main(String[] args) {

        final int MAX_SIZE = 10;
        Score[] scores = new Score[MAX_SIZE];
        int length = 0;

        // new Score(String, int, int, int);
        // => Score 설계도에 땋라 인스턴스를 생성하기
        // => 생성한 후 String, int, int, int 파라미터 값을 받는 생성자를 호출하기
        // => 이렇게 초기화 시킨 인스턴스의 주소 리턴하기
        scores[length++] = new Score("홍길동", 100, 100, 100);
        scores[length++] = new Score("임꺽정", 90, 90, 90);
        scores[length++] = new Score("유관순", 80, 80, 80);

        // 변수에 직접 접근하여, 국영수 합계를 임의로 조작 가능하다
        //scores[0].sum = 20000;

        for (int i = 0; i < length; i++) {
            printScore(scores[i]);
        }
    }
    static void printScore(Score s) {
        System.out.printf("%s: 합계=%d, 평균=%.1f\n",
                s.getName(), s.getSum(), s.getAver());
    }
}