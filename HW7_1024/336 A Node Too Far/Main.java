import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(System.in);

    int caseNum = 0;
    for (int testCase = 1; in.hasNext(); testCase++) {
      final int NC = Integer.parseInt(in.next());
      if (NC == 0) {break;}

      //adj will map each node to its adjacency list (or to nothing if it has no neighbors)
      HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
      for (int i = 0; i < NC; i++) {
        int u = Integer.parseInt(in.next()), v = Integer.parseInt(in.next());
        // System.out.println(u + " " + v);
        if (!adj.containsKey(u)) { adj.put(u, new ArrayList<>());}
        if (!adj.containsKey(v)) { adj.put(v, new ArrayList<>());}
        ArrayList<Integer> uAdj = adj.get(u), vAdj = adj.get(v);

        //graph undirected, so
        uAdj.add(v);
        vAdj.add(u);
      }

      int startNode = -1;
      int ttlField = -1;
      while ((startNode != 0) || (ttlField != 0)) {
        startNode = Integer.parseInt(in.next());
        ttlField = Integer.parseInt(in.next());
        if (startNode == 0 && ttlField == 0) {break;}

        HashMap<Integer, Integer> dist = new HashMap<>();
        for (Integer node : adj.keySet()) { dist.put(node, Integer.MAX_VALUE);}

        dist.put(startNode, 0);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        
        while (!queue.isEmpty()) {
          int u = queue.poll();
          for (Integer node : adj.get(u)) {
            if (dist.get(node) == Integer.MAX_VALUE) {
              queue.add(node);
              dist.put(node, dist.get(u) + 1);
            }
          }
        }
        int numTooFar = 0;
        for (Integer node : dist.keySet()) {
          if (dist.get(node) > ttlField) {
            numTooFar += 1;
          }
        }
        System.out.println("Case " + ++caseNum + ": " + numTooFar + " nodes not reachable from node " + startNode + " with TTL = " + ttlField + ".");
      }

    }

  }

}
