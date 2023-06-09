package step03;
//낱개의 변수 사용
//낱개의 변수 재사용
// 배열 사용
public class Test {

    public static void main(String[] arg){
        String name[10];
        int kor[10];
        int eng[10];
        int math[10];
        int sum[10];
        float avg[10];
        int length = 0;

        name[length] = "홍길동";
        kor[length] = 100;
        eng[length] = 100;
        math[length] =100;
        sum[length] = kor[length] +eng[length] + math[length];
        avg[length] = sum/3f;

        System.out.printf("%s: 합계 = %d, 평균=%f\n",name[length], sum[length],avg[length]);

        name[length] = "임꺽정";
        kor[length] = 100;
        eng[length] = 100;
        math[length] =70;
        sum[length] = kor[length] +eng[length] + math[length];
        avg[length] = sum[length]/3f;

        System.out.printf("%s: 합계 = %d, 평균=%f\n",name[length], sum[length],avg[length]);

        [length] = "유관순";
        kor[length] = 80;
        eng[length] = 100;
        math[length] =100;
        sum[length] = kor[length] +eng[length] + math[length];
        avg[length] = sum[length]/3f;

        System.out.printf("%s: 합계 = %d, 평균=%f\n",name[length], sum[length],avg[length]);
    }
}
