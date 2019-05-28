import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(System.in);//new File("C:\\Users\\casey\\Desktop\\Competitive Programming\\Coding Challenges\\HW6_1010\\639 Dont Get Rooked\\in.txt"));//

    while (in.hasNext()) {
      int size = in.nextInt();
      if (size == 0) {
        break;
      }
      in.nextLine();
      char[][] board = new char[size][];
      for (int j = 0; j < size; j++) {
        board[j] = in.nextLine().toCharArray();
      }
      int maxRooks = 0;
    /* for each possible position (row, col), call the recursive method to find all legal configurations
       starting here */
      int result = findMaxRooks(size, board, 0, 0,0, 0, maxRooks);

      System.out.println(result);
    }
  }
  private static int findMaxRooks(int size, char[][] board, int row, int col, int nextRow, int nextCol, int maxSoFar) {
    if (row > size -1 /*&& col <= size-1*/) {return maxSoFar;}
    else {
      if (col <= size-2) {nextCol = col + 1; nextRow = row;}
      else if (col == size-1) {nextRow = row + 1; nextCol = 0;}

      int result = 0;
      int res1 = 0;
      if (canPlace(size, board, row, col)) {
        // if we can place a rook at this cell, we use backtracking to first continue the recursion for:
        //    1. the case that we placed the rook
        //    2. the case that we do NOT place the rook, and in the end we use the one that gives the higher "Rook COUNT"
        board[row][col] = 'R';
        res1 = findMaxRooks(size, board, nextRow, nextCol, 0, 0, maxSoFar) + 1;// row = nextRow, col = nextCol, maxSoFar+=1

        board[row][col] = '.';
      }
      int res2 = findMaxRooks(size, board, nextRow, nextCol,0, 0, maxSoFar) ;

      if (res1 > res2) {result = res1;}
      else {result = res2;}

      if (result > maxSoFar) {maxSoFar = result;}
    }
    return maxSoFar;
  }
  private static boolean canPlace(int size, char[][] board, int row, int col) {

    boolean left = true; boolean right = true;
    boolean up = true; boolean down = true;

    // say e.g. we are at cell (ii,jj)
    // then, we need to be sure that NO rooks are "visible" from this cell
    // first check row in both directions
    if (board[row][col] == 'X') {return false;}
    if (col == 0) {  //search right
      for (int k = col + 1; k < size; k++) {
        if (board[row][k] == 'X') {right = true; break;}
        if (board[row][k] == 'R') {right = false; break;}

      }
    }
    else if (col == size -1) { // search left
      for (int k = col - 1; k >= 0; k--) {
        if (board[row][k] == 'X') {left = true; break;}
        if (board[row][k] == 'R') {left = false; break;}
      }
    }
    else {
      for (int k = col + 1; k < size; k++) { // search both right and left
        if (board[row][k] == 'X') {right = true; break;}
        if (board[row][k] == 'R') {right = false; break;}
      }
      for (int k = col - 1; k >= 0; k--) {
        if (board[row][k] == 'X') {left = true; break;}
        if (board[row][k] == 'R') {left = false; break;}
      }
    }
    // then check column
    if (row == 0) { //search down
      for (int k = row + 1; k < size; k++) {
        if (board[k][col] == 'X') {down = true; break;}
        if (board[k][col] == 'R') {down = false; break;}
      }
    }
    else if (row == size -1) { // search up
      for (int k = row - 1; k >= 0; k--) {
        if (board[k][col] == 'X') {up = true; break;}
        if (board[k][col] == 'R') {up = false; break;}
      }
    }
    else {
      for (int k = row + 1; k < size; k++) { // search both up and down
        if (board[k][col] == 'X') {down = true; break;}
        if (board[k][col] == 'R') {down = false; break;}
      }
      for (int k = row - 1; k >= 0; k--) {
        if (board[k][col] == 'X') {up = true; break;}
        if (board[k][col] == 'R') {up = false; break;}
      }
    }
    boolean vertical = up && down;
    boolean horizontal = left && right;
    boolean toReturn = (vertical && horizontal);
    return toReturn;
  }

}
