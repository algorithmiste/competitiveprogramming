import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    for (int testCase = 1; testCase <= n; ++testCase) {
      if (testCase > 1) {
        System.out.println();
      }
      int numSegments = in.nextInt();
      if (numSegments == 1) {
        System.out.println(1 + "\n");
        continue;
      }
      double[] segments = new double[numSegments * 4];
      for (int j = 0; j < numSegments * 4; ++j) {
        segments[j] = in.nextDouble();
      }
      ArrayList<double[]> lines = new ArrayList<>();
      for (int i = 0; i < numSegments * 4; i += 4) {
          double[] lined = new double[4];
          lined[0] = segments[i];
          lined[1] = segments[i + 1];
          lined[2] = segments[i + 2];
          lined[3] = segments[i + 3];
          lines.add(lined);
      }
      int total = numSegments;
      for (int i = 0; i < lines.size() - 1; ++i) {
          double x1 = lines.get(i)[0], y1 = lines.get(i)[1], x2 = lines.get(i)[2], y2 = lines.get(i)[3];
          for (int j = i + 1; j < lines.size(); ++j) {
              double x3 = lines.get(j)[0], y3 = lines.get(j)[1], x4 = lines.get(j)[2], y4 = lines.get(j)[3];
                if ((x1 == x3 && x2 == x4 && y1 == y3 && y2 == y4) || x1 == x4 && x2 == x3 && y1 == y4 && y2 == y3) {
                    --total;
                    lines.remove(j);
                }
          }
      }

      for (int k = 0; k < lines.size() - 1; ++k) {
          double x1 = lines.get(k)[0], y1 = lines.get(k)[1], x2 = lines.get(k)[2], y2 = lines.get(k)[3];
          for (int m = k + 1; m < lines.size(); ++m) {
            double x3 = lines.get(m)[0], y3 = lines.get(m)[1], x4 = lines.get(m)[2], y4 = lines.get(m)[3];
            if (((x1 != x3 && y1 != y3) || (x1 != x4 && y1 != y4)) && ((x2 != x3 && y2 != y3) || (x2 != x4 && y2 != y4))) {
                double[] pq = solve2x2(x1 - x2, x4 - x3, y1 - y2, y4 - y3, x4 - x2, y4 - y2);

                if (pq != null && (pq[0] >= 0 && pq[0] <= 1) && (pq[1] >= 0 && pq[1] <= 1)) {
                    double p = pq[0], q = pq[1];
                    if (p > 0 && p < 1) {++total;}
                    if (q > 0 && q < 1) {++total;}
                } else {
                    if ((x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1)) {total += 2;}
                }
            }
          }
      }
      System.out.println(total);

    }
    // solve the system of 2 linear equations in 2 unknowns p and q:
    // [a b] [p] = [e]
    // [c d] [q]   [f]
    // given 2x2 matrix a,b,c,d and 2x1 vector e,f:
    // return null if the matrix is not invertible,
    // otherwise the unique solution is p=ans[0] and q=ans[1]
  }
    public static double[] solve2x2(double a, double b, double c, double d, double e, double f){
      double determinant = a * d - b * c;
      if (determinant == 0.0) {return null;}
      double[] ans = new double[2];
      // inverse of [a b] is [d -b] / determinant; multiply this by [e]
      //            [c d]    [-c a]                                 [f]
      ans[0] = (d * e - b * f) / determinant;
      ans[1] = (-c * e + a * f) / determinant;
      return ans;
    }



}

