import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(System.in);//new File("C:\\Users\\casey\\Desktop\\Competitive Programming\\Coding Challenges\\HW7_1024\\532 Dungeon Master\\in.txt"));//System.in);

    while (in.hasNext()) {

      final int L = Integer.parseInt(in.next()), R = Integer.parseInt(in.next()), C = Integer.parseInt(in.next());
      if (L == 0 && R == 0 && C == 0) {break;}
      int minutes = 0;

      char[][][] dungeon = new char[L][R][C];
      for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
          String row = in.next();
          char[] rowArr = row.toCharArray();
          int k = 0;
          while (k < C) {
            for (Character c : rowArr) {
              dungeon[i][j][k] = c;
              k++;
            }
          }
        }
      }

      //adj will map each node to its adjacency list
      HashMap<String, ArrayList<String>> adj = new HashMap<>();
      String start = "", end = "", cell = "", u = "";
      for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
          for (int k = 0; k < C; k++) {
            cell = ""; u = "";
            if (dungeon[i][j][k] != '#') {
              if (dungeon[i][j][k] == 'S') {
                if (i < 10) {
                  start += "0"+String.valueOf(i);
                }
                else{start += String.valueOf(i);}
                if (j < 10) {
                  start += "0"+String.valueOf(j);
                }
                else{start += String.valueOf(j);}
                if (k < 10) {
                  start += "0"+String.valueOf(k);
                }
                else{start += String.valueOf(k);}

                u = start;
              }
              else if (dungeon[i][j][k] == 'E') {
                if (i < 10) {
                  end += "0"+String.valueOf(i);
                }
                else{end += String.valueOf(i);}
                if (j < 10) {
                  end += "0"+String.valueOf(j);
                }
                else{end += String.valueOf(j);}
                if (k < 10) {
                  end += "0"+String.valueOf(k);
                }
                else{end += String.valueOf(k);}

                u = end;
              }
              else if (dungeon[i][j][k] == '.' /*!= 'S' && dungeon[i][j][k] != 'E'*/) {
                if (i < 10) {
                  cell += "0"+String.valueOf(i);
                }
                else{cell += String.valueOf(i);}
                if (j < 10) {
                  cell += "0"+String.valueOf(j);
                }
                else{cell += String.valueOf(j);}
                if (k < 10) {
                  cell += "0"+String.valueOf(k);
                }
                else{cell += String.valueOf(k);}

                u = cell;
              }
              // build adjacency list for u

              adj.put(u, new ArrayList<>());
              ArrayList<String> uAdj = adj.get(u);

              // get east
              if (k - 1 >= 0 && dungeon[i][j][k-1] != '#') {
                String v = "";
                if (i < 10) {
                  v += "0"+String.valueOf(i);
                }
                else{v += String.valueOf(i);}
                if (j < 10) {
                  v += "0"+String.valueOf(j);
                }
                else{v += String.valueOf(j);}
                if (k-1 < 10) {
                  v += "0"+String.valueOf(k-1);
                }
                else{v += String.valueOf(k-1);}
//                String v = String.valueOf(i)+String.valueOf(j)+String.valueOf(k-1);
                uAdj.add(v);
              }
              // get west
              if (k+1 < C && dungeon[i][j][k+1] != '#') {
                String v = "";
                if (i < 10) {
                  v += "0"+String.valueOf(i);
                }
                else{v += String.valueOf(i);}
                if (j < 10) {
                  v += "0"+String.valueOf(j);
                }
                else{v += String.valueOf(j);}
                if (k+1 < 10) {
                  v += "0"+String.valueOf(k+1);
                }
                else{v += String.valueOf(k+1);}

                uAdj.add(v);
              }
              // get north
              if (j-1 >= 0 && dungeon[i][j-1][k] != '#') {
                String v = "";
                if (i < 10) {
                  v += "0"+String.valueOf(i);
                }
                else{v += String.valueOf(i);}
                if (j-1 < 10) {
                  v += "0"+String.valueOf(j-1);
                }
                else{v += String.valueOf(j-1);}
                if (k < 10) {
                  v += "0"+String.valueOf(k);
                }
                else{v += String.valueOf(k);}

                uAdj.add(v);
              }
              // get south
              if (j+1 < R && dungeon[i][j+1][k] != '#') {
                String v = "";
                if (i < 10) {
                  v += "0"+String.valueOf(i);
                }
                else{v += String.valueOf(i);}
                if (j+1 < 10) {
                  v += "0"+String.valueOf(j+1);
                }
                else{v += String.valueOf(j+1);}
                if (k < 10) {
                  v += "0"+String.valueOf(k);
                }
                else{v += String.valueOf(k);}

                uAdj.add(v);
              }
              // get up
              if (i+1 < L && dungeon[i+1][j][k] != '#') {
                String v = "";
                if (i+1 < 10) {
                  v += "0"+String.valueOf(i+1);
                }
                else{v += String.valueOf(i+1);}
                if (j < 10) {
                  v += "0"+String.valueOf(j);
                }
                else{v += String.valueOf(j);}
                if (k < 10) {
                  v += "0"+String.valueOf(k);
                }
                else{v += String.valueOf(k);}

                uAdj.add(v);
              }
              // get down
              if (i-1 >= 0 && dungeon[i-1][j][k] != '#') {
                String v = "";
                if (i-1 < 10) {
                  v += "0"+String.valueOf(i-1);
                }
                else{v += String.valueOf(i-1);}
                if (j < 10) {
                  v += "0"+String.valueOf(j);
                }
                else{v += String.valueOf(j);}
                if (k < 10) {
                  v += "0"+String.valueOf(k);
                }
                else{v += String.valueOf(k);}

                uAdj.add(v);
              }

            }
          }
        }
      }

      HashMap<String, Integer> dist = new HashMap<>();
      for (String str : adj.keySet()) { // str == cell
        dist.put(str, Integer.MAX_VALUE);
      }
      dist.put(start, 0);

      LinkedList<String> queue = new LinkedList<>();
      queue.add(start);

      HashMap<String, String> prev = new HashMap<>();
      prev.put(start, null);

      while (!queue.isEmpty()) {
        String x = queue.poll(); // x == u
        for (String str : adj.get(x)) {
          if (dist.get(str) == Integer.MAX_VALUE) {
            queue.add(str);
            dist.put(str, dist.get(x) + 1);
            prev.put(str, x);
          }
        }
      }

      String v = end; int count = 0;
      while (prev.get(v) != null && v != start) {
        count++;
        v = prev.get(v);
      }
      if (v.equals(start)) {System.out.println("Escaped in " + count + " minute(s).");} //dist.get(end);
      else{System.out.println("Trapped!");}

    }
  }


}
