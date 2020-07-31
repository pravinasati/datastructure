package com.example.sample;

public class Factorial {

  public static void main(String[] args) {

    System.out.println("fact(5) = " + fact(5));
  }

  private static int fact(int i) {

    if (i <= 0) {
      return 0;
    }
    if (i == 1) {
      return 1;
    }

    return i*fact(i-1);
  }
}
