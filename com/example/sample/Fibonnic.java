package com.example.sample;

public class Fibonnic {

  public static void main(String[] args) {
    System.out.println("fibbo(10) = " + fibbo(10));
  }

  private static int fibbo(int i) {

    if (i == 0) {
      return 0;
    }
    if (i == 1) {
      return 0;
    }
    if (i == 2) {
      return 1;
    }

    return fibbo(i-2) + fibbo(i-1);

  }
}
