package Test_0609.step17.vo;

 public class Score {

     // 프로그래밍의 일관성을 위해 그냥 막아버린게 name
     private String name;

     // 직접 접근을 허용했을 때 무효한 값을 저장 할 수 있기 때문에
     // private로 접근을 막았다
     private int kor;
     private int eng;
     private int math;
     private int sum;
     private float aver;

     public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.compute();
        }

     public void compute() {
            this.sum = this.kor + this.eng + this.math;
            this.aver = this.sum / 3f;
         }

    // getter: private으로 접근이 막힌 변수의 값을 리턴해주는 메서드
     public int getSum(){
         return this.sum;
     }

     public float getAver(){
         return this.aver;
     }

     public String getName(){
         return this.name;
     }

     public int getKor(){
         return this.kor;
     }
     public int getEng(){
         return this.eng;
     }
     public int getMath(){
         return this.math;
     }
 }


