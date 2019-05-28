import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {//throws FileNotFoundException{
      Scanner in = new Scanner(System.in); //new File("C:\\Users\\casey\\Desktop\\Competitive Programming\\Coding Challenges\\HW6_1010\\628 Passwords\\in.txt"));//System.in);
      while (in.hasNext()) {
        int numWords = in.nextInt(); in.nextLine();
        ArrayList<String> dict = new ArrayList<>();
        for (int i = 0; i < numWords; i++) {
          String word = in.nextLine();
          dict.add(word);
        }
        int numRules = in.nextInt(); in.nextLine();
        for (int j = 0; j < numRules; j++) {
          System.out.println("--"); // line break
          String rule = in.nextLine();
          // for each possible rule, call the recursive method to find all passwords using the words in dict abiding by the jth rule
          for (String word : dict) {
            String possible = "";
            for (Character c : rule.toCharArray()) {
              if (c.equals('#')) { possible += word; }
              else { possible += c; }
            }
            int psswdLength = possible.length();
            generatePassword(word, rule, psswdLength, -1, "");
          }
        }
      }
    }
    private static void generatePassword(String word, String rule, int psswdLength, int currentCharIndex, String inProgress) {
      int curLength = inProgress.length();
      currentCharIndex++;
      if (curLength == psswdLength ){
        System.out.println(inProgress);
      }
      else {
        if (rule.charAt(currentCharIndex) == '#') {
          generatePassword(word, rule, psswdLength, currentCharIndex, inProgress += word);
        } else if (rule.charAt(currentCharIndex) == '0') {
          for (int i = 0; i < 10; i++) {
            if (i != 0) {inProgress = inProgress.substring(0, inProgress.length()-1);}
            generatePassword(word, rule, psswdLength, currentCharIndex, inProgress += String.valueOf(i));
          }
        }
      }
    }
}

