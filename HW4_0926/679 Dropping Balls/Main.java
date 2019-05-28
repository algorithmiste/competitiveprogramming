import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();

    for(int i = 0; i <= testCases; i++){
      int maxDepth = in.nextInt();
      if(maxDepth == -1){ 
        break;
      }
      int ithBall = in.nextInt();
      int valueToReturn = 1;
      int min = 1;

      for(int j = 0; j <= maxDepth - 2; j++){
        min *= 2;
      }
      int fbt = min;
      for(int k = 1; k < ithBall; k++){
        if(fbt == (min*2) - 1){
          fbt = min - 1;
        }
        fbt++;
      }
      for(int m = 0; m <= maxDepth - 2; m++){
        if ((fbt & (1<<m)) != 0){
          valueToReturn = valueToReturn << 1; 
          valueToReturn |= (1 << 0);
        }
        else{
          valueToReturn = valueToReturn << 1;
        }
      }
      System.out.print(valueToReturn + "\n");
    }
  }
}