package Test_0609.step17;

import Test_0609.step17.vo.Score;// 4) 클래스를 이용하여 데이터 타입 정의(중첩클래스; 로컬 클래스)
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
//      => getter정의
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

        // 합계와 평균 계산이 끝난 후에 국어 점수를 변경한다면?
        // => 국영수 점수와 합계, 평균 점수가 일치하지 않는 문제가 발생
        // 데이터에 결함이 발생
        // 국영수 점수를 변경한 후에 compute() 를 호출하면 되지 않을까?
        // =>만약 개발자가 compute() 호출하는 것을 잊어 먹는다면 아무 소용 없다
        // 만약 유효하지 않은 국영수 점수를 입력한다면?
        // 막을 길이 없다

        scores[0].kor = 70;
        scores[0].kor = 7000;// 이런 어이없는 점수를 막을 수 없다


        //scores[0].compute(); // 호출하지 않으면 아무 소용이 없어져 버림



        // 변수에 직접 접근하여, 국영수 합계를 임의로 조작 가능하다
        //scores[0].sum = 20000;

        for (int i = 0; i < length; i++) {
            printScore(scores[i]);
        }
    }
    static void printScore(Score s) {
        System.out.printf("%s: 국어=%d, 영어=%d, 수학=%d, 합계=%d, 평균=%.1f\n",
                s.getName(),s.kor, s.eng, s.math, s.getSum(), s.getAver());
    }
}