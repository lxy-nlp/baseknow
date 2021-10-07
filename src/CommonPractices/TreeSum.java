package CommonPractices;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

public class TreeSum {
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static LinkedList<LinkedList<Integer>> res;
    public static LinkedList<Integer> tmp;

    public static int sumNumbers(TreeNode root) {
        res = new LinkedList();
        tmp = new LinkedList();
        dfs(root);
        int sum = 0;
        for(LinkedList<Integer> list : res)
        {
            for(int i = 0; i < list.size();i++)
            {
                sum += list.get(i) *  Math.pow(10,list.size() - i - 1) ;
            }
        }
        return sum;
    }

    public static void dfs(TreeNode root)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            res.add(new LinkedList(tmp));
            return;
        }
        if(root.left != null)
        {
            tmp.add(root.val);
            dfs(root.left);
            tmp.removeLast();

        }
        if(root.right != null)
        {
            tmp.add(root.val);
            dfs(root.right);
            tmp.removeLast();
        }
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        int res = sumNumbers(root);
        System.out.println(res);
    }
}
