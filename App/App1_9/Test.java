package App1_9;

import util.Calculator;
public class Test {
    public static void main(String[] args) {
        // 2 * 3 + 7 - 2 / 2 = ?
        // 3 - 1 * 7 + 15 / 3 =?
        // => 연산자 우선 순위를 고려하지 않고 앞에서부터 뒤로 순차적으로 계산한다. / -> 위 계산 동시에 수행하기


        Calculator c1 = new Calculator();
        Calculator c2 = new Calculator();

        Calculator.init(c1,2);
        Calculator.multiple(c1,3);
        Calculator.plus(c1,7);
        Calculator.minus(c1,2);
        Calculator.divide(c1,2);

        System.out.println(Calculator.getResult(c1));

        Calculator.init(c2,3);
        Calculator.minus(c2,1);
        Calculator.multiple(c2,7);
        Calculator.plus(c2,15);
        Calculator.divide(c2,3);

        System.out.println(Calculator.getResult(c2));
    }
}