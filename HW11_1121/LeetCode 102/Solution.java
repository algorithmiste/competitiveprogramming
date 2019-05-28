/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lol = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
        getLevel(root, 0, levelMap);

       Object[] list = levelMap.keySet().toArray();

        for (Object level: list) {
            List<Integer> listToAdd = new ArrayList<>();
            for(int val : levelMap.get((int)level)) {
                listToAdd.add(val);
            }
            lol.add(listToAdd);
        }
        return lol;

    }
    public void getLevel(TreeNode root, int curLevel, HashMap<Integer, ArrayList<Integer>> levelMap) {
        if (root != null) {
            if (!levelMap.containsKey(curLevel)) {
                levelMap.put(curLevel, new ArrayList<>());
                levelMap.get(curLevel).add(root.val);
            }
            else {
                levelMap.get(curLevel).add(root.val);
            }
            curLevel += 1;
            getLevel(root.left, curLevel, levelMap);
            getLevel(root.right, curLevel, levelMap);

        }
    }
}
