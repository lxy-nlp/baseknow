package Offer;

import java.util.HashMap;

class TreeNode {
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

// 打家劫舍问题的三种解法
public class Rob {
    // 暴力递归
    public int rob(TreeNode root)
    {
        if(root == null)
            return 0;
        int money = root.val;
        if(root.left != null)
            money += rob(root.left.left) + rob(root.left.right);
        if(root.right != null)
            money += rob(root.right.left) + rob(root.right.right);
        return Math.max(money,rob(root.left)+rob(root.right));
    }

    // 带记忆的递归
    public int rob2(TreeNode root)
    {
        HashMap<TreeNode,Integer> memo = new HashMap<>();
        return robInternel(root,memo);
    }
    public int robInternel(TreeNode root,HashMap<TreeNode,Integer> memo)
    {
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if(root.left != null)
            money += (robInternel(root.left.left,memo) + robInternel(root.left.right,memo));
        if(root.right != null)
            money += (robInternel(root.right.left,memo) + robInternel(root.right.left,memo));
        int result = Math.max(money,robInternel(root.left, memo) + robInternel(root.right,memo));
        memo.put(root,result);
        return result;
    }
    public int rob3(TreeNode root)
    {
        int[] result = robInternal(root);
        return Math.max(result[0],result[1]);
    }
    public int[] robInternal(TreeNode root)
    {
        if(root == null)    return new int[2];
        int[] result = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
