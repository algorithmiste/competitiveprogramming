import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(System.in);//new File("C:\\Users\\casey\\Desktop\\Competitive Programming\\Coding Challenges\\HW8_1031\\787 Maximum Sub-sequence Product\\in.txt"));//System.in);

    while (in.hasNext()) {
      ArrayList<Integer> arr = new ArrayList<>();
      for(int next = in.nextInt(); next != -999999; next = in.nextInt()) {
        arr.add(next);
      }

      BigInteger[] minSubArr = new BigInteger[arr.size()];
      BigInteger[] maxSubArr = new BigInteger[arr.size()];

      minSubArr[0] = BigInteger.valueOf(arr.get(0)); maxSubArr[0] = BigInteger.valueOf(arr.get(0));
//      BigInteger max = BigInteger.ZERO, min = BigInteger.ZERO;
      BigInteger maxToReturn = maxSubArr[0];

      for (int i = 1; i < arr.size(); ++i) {
        BigInteger x = BigInteger.valueOf(arr.get(i));

        if (BigInteger.ZERO.compareTo(x) == -1) { // x > 0
          //find max
          maxSubArr[i] = x.max(x.multiply(maxSubArr[i-1]));
          minSubArr[i] = x.min(x.multiply(minSubArr[i-1]));
        }
        else { // x <= 0
          maxSubArr[i] = x.max(x.multiply(minSubArr[i-1]));
          minSubArr[i] = x.min(x.multiply(maxSubArr[i-1]));
        }

        if (minSubArr[i].compareTo(maxSubArr[i]) == -1) {
          if (maxToReturn.compareTo(maxSubArr[i]) == -1) {
            maxToReturn = maxSubArr[i];
          }
        }
        else {
          if (maxToReturn.compareTo(minSubArr[i]) == -1) {
            maxToReturn = minSubArr[i];
          }
        }
        
      }
      System.out.println(maxToReturn);
    }
    return;


  }
}
