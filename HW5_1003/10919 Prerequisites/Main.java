import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args)  {//throws FileNotFoundException{
    Scanner in = new Scanner(System.in);//new File("C:\\Users\\casey\\Desktop\\Competitive Programming\\Coding Challenges\\HW5_1003\\10919 Prerequisites\\in.txt"));//System.in);

    while (in.hasNextLine()) {

      String next = in.nextLine();
      if (next.charAt(0) == '0') {
        break;
      }
      String[] nextArr = next.split(" ");
      Boolean isValid = true;

      int numCourses = Integer.parseInt(nextArr[0]);
      int numCategories = Integer.parseInt(nextArr[1]);
      int categoryCount = numCategories;
      String codes = " ";
      HashMap<String, Integer> courseMap = new HashMap<>();

      for (codes = in.nextLine(); !codes.substring(0, 4).contains(" "); codes = in.nextLine()) {
        String[] codesArr = codes.split(" "); // contains the courses SELECTED

        for (int m = 0; m < codesArr.length; m++) {
          courseMap.put(codesArr[m], 1);
        }
      }
      String category = codes;
      String[] categoryArr = category.split(" ");
      int numCoursesInCategory = Integer.parseInt(categoryArr[0]);
      int minCourses = Integer.parseInt(categoryArr[1]);
      int num = 0;
      --categoryCount;
      for (int t = 0; t < numCoursesInCategory; t++) {
        if (courseMap.get(categoryArr[t + 2]) != null) {num += 1;}//containsKey(categoryArr[t])) {num +=1;}
        if (num >= minCourses) {break;}
      }
      if (num < minCourses) {
        isValid = false;
        while (categoryCount > 0) {in.nextLine(); --categoryCount;}
      }

      if (isValid) {
        for (int k = 1; k < numCategories; k++) { // lines (?+1...numCategories)
          --categoryCount;
          category = in.nextLine();
          categoryArr = category.split(" ");
          // System.out.println("Category" + (k+1) + ": " + Arrays.toString(categoryArr));
          numCoursesInCategory = Integer.parseInt(categoryArr[0]);
          minCourses = Integer.parseInt(categoryArr[1]);
          num = 0;
          for (int t = 0; t < numCoursesInCategory; t++) {
            if (courseMap.get(categoryArr[t + 2]) != null) {num += 1; }//containsKey(categoryArr[t])) {num +=1;}
            if (num >= minCourses) {break;}
          }
          if (num < minCourses) {
            isValid = false;
            while (categoryCount > 0) {in.nextLine(); --categoryCount;}
            break;
          }
        }
    }
      if (isValid) {System.out.println("yes");}
      else {System.out.println("no");}

    }
    return;

  }

}
