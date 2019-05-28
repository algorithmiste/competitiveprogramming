import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numCases = in.nextInt();

    for (int i = 0; i < numCases; ++i) {
      int numCommands = in.nextInt();
      ArrayList<String> cmds = new ArrayList<>();
      ArrayList<Integer> units = new ArrayList<>();
      for (int j = 0; j < numCommands; ++j) {
        cmds.add(in.next()); units.add(Integer.parseInt(in.next()));
      }
      double x_coord = 0, y_coord = 0, angle = 0;
      for(int k = 0; k < cmds.size(); ++k) {
        String cmd = cmds.get(k);
        int unit = units.get(k);
        double proj = 2*Math.PI/360*angle;
        if (cmd.equals("lt")) {
          angle += unit;
        }
        else if (cmd.equals("rt")) {
          angle -= unit;
        }
        else if (cmd.equals("fd")) {
          x_coord += unit * Math.cos(proj);
          y_coord += unit * Math.sin(proj);
        }
        else if (cmd.equals("bk")) {
          x_coord -= unit * Math.cos(proj);
          y_coord -= unit * Math.sin(proj);
        }
      }
      double toReturn = Math.sqrt(Math.pow(x_coord, 2) + Math.pow(y_coord, 2));
      System.out.println(Math.round(toReturn));
    }

  }

}
