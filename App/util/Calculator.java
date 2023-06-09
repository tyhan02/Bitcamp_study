package util;

public class Calculator {

    public int result = 0;

    public static int getResult(Calculator c){
        return c.result;
    }
    public static void init(Calculator c, int a) {
        c.result = a;
    }
    public static void plus(Calculator c, int a) {
        c.result += a;
    }
    public static void minus(Calculator c, int a) {
        c.result -= a;
    }
    public static void multiple(Calculator c, int a) {
        c.result *= a;
    }
    public static void divide(Calculator c, int a) {
        c.result /= a;
    }
}