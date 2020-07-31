package my;

import java.util.Arrays;
import java.util.List;

public class BiggestNumber {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1,2,31,4,2,8,4,9,0);

    System.out.println("biggestNum(list,list.size(), 0) = " + biggestNum(list, list.size()-1, 0));

  }

  private static int biggestNum(List<Integer> list, int index, int bigNum) {


    if (index < 0) {
      return bigNum;
    }

    if (list.get(index) > bigNum)
      bigNum = list.get(index);

    return biggestNum(list, index-1, bigNum);
  }
}
