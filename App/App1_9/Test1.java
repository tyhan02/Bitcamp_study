package App1_9;

public class Test1 {

    public static void main(String[] arg){
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float avg;

        name = "홍길동";
        kor = 100;
        eng = 100;
        math =100;
        sum = kor +eng + math;
        avg = sum/3f;

        System.out.printf("%s: 합계 = %d, 평균=%f\n",name, sum,avg);

        name = "임꺽정";
        kor = 100;
        eng = 100;
        math =70;
        sum = kor +eng + math;
        avg = sum/3f;

        System.out.printf("%s: 합계 = %d, 평균=%f\n",name, sum,avg);

        name = "유관순";
        kor = 80;
        eng = 100;
        math =100;
        sum = kor +eng + math;
        avg = sum/3f;

        System.out.printf("%s: 합계 = %d, 평균=%f\n",name, sum,avg);
    }
}
