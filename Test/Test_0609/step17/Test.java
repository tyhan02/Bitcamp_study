package Test_0609.step17;

import Test_0609.step17.vo.Score;
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
// 16) 필드에 직접 접근을 막고, setter를 정의하는 이유
// 17) 필드의 직접 접근을 막기: 인스턴스 변수에 무효한 값이 저장되지 않게 하기 위해
//      => getter 정의: 값을 꺼낼 때 사용
//      => setter 정의: 값을 변경할 때 사용, 단 유효한 값을 저장하도록 통제
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
        scores[length++] = new Score("임꺽정", 90, 800, 90);
        scores[length++] = new Score("유관순", 80, 80, 80);


        //scores[0].kor = 7000; 접근 불가
        scores[0].setKor(70); //setter 을 통해서는 값 변경 가능, 단 유효한 값만 가능(0-100)
        //scores[0].compute(); // 호출하는 것을 잊어버릴 수 있기 때문에 setter에서 호출한다


        // 변수에 직접 접근하여, 국영수 합계를 임의로 조작 가능하다
        //scores[0].sum = 20000;

        for (int i = 0; i < length; i++) {
            printScore(scores[i]);
        }
    }
    static void printScore(Score s) {
        System.out.printf("%s: 국어=%d, 영어=%d, 수학=%d, 합계=%d, 평균=%.1f\n",
                s.getName(),s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
    }
}