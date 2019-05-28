import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(System.in);//new File("C:\\Users\\casey\\Desktop\\Competitive Programming\\Coding Challenges\\HW8_1031\\10465 Homer Simpson\\in.txt"));//System.in);

    while (in.hasNext()) {

      int m = in.nextInt();
      int n = in.nextInt();
      final int T = in.nextInt();

      int[] subArr = new int[T+1];
//      int[] minsEating = new int[T];
      if (n > m) {int temp = n; n = m; m = temp;}

      for (int i = 0; i <= T; ++i) {
        // determine the max number of burgers that can be eaten if exactly i minutes must be used
        if (i == 0) {subArr[0] = 0; continue;}

        if (i < n) {subArr[i] = -1;  continue;}


        // to calculate the ith entry given earlier entries, consider the following possibilities:
        // 1. Assuming N <= M, if i is divisible by n then you can determine the optimal amount without looking up earlier subproblems
        if ((i) % n == 0) {subArr[i] = (i) / n; continue;}
        // else, atleast one of the M minute burgers must be eaten

        if (i >= m && i % n != 0 ) {
          if (subArr[i-m] != -1) {
            subArr[i] = subArr[i-m] + 1;
          }
          else {subArr[i] = -1;}
        } // N burgers can be eaten but not enough time for even 1 M-minute burger to be eaten
        else if (i < m && i % n != 0){subArr[i] = -1;}
        // finally, if you know it's possible to fill exactly i minutes and at least 1 M minute burger must be eaten, then
        // the best thing is to look up the optimal way to fill the remaining i - M minutes with eating
      }
//      for (int i : subArr) {System.out.print(i + " ");}
//      System.out.println();

      if (subArr[T] != -1) {System.out.println(subArr[T]); continue;}

      else if (subArr[T] == -1) {
        int counter = T;
        int steps = 0;
        while (subArr[counter] == -1) {
          --counter;
          ++steps;
        }
        System.out.println(subArr[counter] + " " + steps);
      }
    }

  }
}
