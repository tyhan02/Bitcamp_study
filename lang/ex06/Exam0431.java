package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break

public class Exam0431 {
  public static void main(String[] args) {
    // break
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
        if (j == 5)
          break; // break 소속된 현재 반복문을 멈춘다.
      }
      System.out.println();
    }
  }
}


