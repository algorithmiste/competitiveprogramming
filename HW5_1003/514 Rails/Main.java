import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {//throws FileNotFoundException{
      Scanner in = new Scanner(System.in);//new File("C:\\Users\\casey\\Desktop\\Competitive Programming\\Coding Challenges\\HW5_1003\\514 Rails\\in.txt"));

       while (in.hasNextLine()) {
         final int N = Integer.parseInt(in.nextLine());
         if (N == 0) {break;}

         LinkedList<Integer> coach = new LinkedList<>();
         for (int i = 0; i < N; i++) {
           coach.add(i+1);
         }
         for (String perm = in.nextLine(); perm.charAt(0) != '0'; perm = in.nextLine() ) {
           String[] permArr = perm.split(" ");
           Boolean notPossible = false;
           Boolean breakPermLoop = false;
           Stack<Integer> transferStack = new Stack<>();
           LinkedList<Integer> coachClone = (LinkedList<Integer>)coach.clone();

           for (int j = 0; j < permArr.length; j++) {
             if (!transferStack.isEmpty()) {
               if ((transferStack.peek() != Integer.parseInt(permArr[j])) && coachClone.isEmpty()) {
                 notPossible = true; break;
               }
             }
             while ((transferStack.isEmpty()) || (transferStack.peek() != Integer.parseInt(permArr[j]))) {
               if (!transferStack.isEmpty()) {
                 if (transferStack.peek() > Integer.parseInt(permArr[j])) {
                   notPossible = true;
                   breakPermLoop = true;
                   break;
                 }
               }
               transferStack.push(coachClone.poll());
             }
             if (breakPermLoop) {break;}
             transferStack.pop();
           }
           if (!notPossible) {System.out.println("Yes");}
           else {System.out.println("No");}
         }
         System.out.println();
       }

       return;
    }

}
