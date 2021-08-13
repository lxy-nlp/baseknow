package Offer.DataStructure;/*
* 二叉树操作
* 增加
* 删除
* 查找
* 遍历
* */


import java.util.*;


class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int val)
    {
        data = val;
        left = null;
        right = null;
        parent = null;
    }
}

public class BinaryTree {

    private TreeNode root;
    public BinaryTree(){root = null;}

    public TreeNode find(int key)
    {
        TreeNode current = root;
        while(current != null)
        {
            if(key < current.data)
            {
                if(current.left == null)
                    return current;
                current = current.left;
            }else if(key > current.data)
            {
                if(current.right == null)
                    return current;
                current = current.right;
            }else
                return current;
        }
        return null;
    }

    // 找到后继节点 其实这个是一个排序的二叉树 左子树比右子树要小
    public TreeNode findSuccessor(TreeNode n)
    {
        if(n.right == null)
            return n;
        TreeNode current = n.right;
        TreeNode parent = n.right;
        while(current != null)
        {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    public TreeNode getRoot(){  return root;    }
    public void put(int value)
    {
        TreeNode newNode = new TreeNode(value);
        if(root == null)
            root = newNode;
        else{
            TreeNode parent = find(value);
            if(value < parent.data)
            {
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            }
            else{
                parent.right = newNode;
                parent.right.parent = parent;
                return;
            }
        }

    }
    public boolean remove(int value)
    {
        TreeNode temp = find(value);
        if(temp.data != value)
            return false;
        if(temp.right == null && temp.left == null)
        {
            if(temp == root)
                root = null;

            else if(temp.parent.data < temp.data)
                temp.parent.right = null;
            else
                temp.parent.left = null;
            return true;
        }

        else if(temp.left  != null && temp.right != null)
        {
            TreeNode successor = findSuccessor(temp);
            successor.left = temp.left;
            successor.left.parent = successor;

            if(successor.parent != temp)
            {
                if(successor.right != null)
                {
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;

                }
            }
            if(temp == root)
            {
                successor.parent = null;
                root = successor;
                return true;
            }
        }
        return false;
    }
    // 三种遍历
    public void preOrder(TreeNode localRoot)
    {
        if(localRoot == null)
            return;
        System.out.println(localRoot.data);
        preOrder(localRoot.left);
        preOrder(localRoot.right);
    }

    public void inOrder(TreeNode localRoot)
    {
        if(localRoot == null)
            return;
        System.out.println(localRoot.data);
        inOrder(localRoot.left);
        inOrder(localRoot.right);
    }

    public void postOrder(TreeNode localRoot)
    {
        if(localRoot == null)
            return;
        System.out.println(localRoot.data);
        postOrder(localRoot.left);
        postOrder(localRoot.right);
    }
    // 三种遍历的迭代方法
    public void inorder(TreeNode localRoot, List<Integer> res)
    {
        if(localRoot == null || (localRoot.left == null && localRoot.right == null))
            return;
        Stack<TreeNode> note = new Stack<TreeNode>();
        while(root != null || !note.isEmpty())
        {
            while(root != null)
            {
                note.push(localRoot);
                localRoot = localRoot.left;
            }
            localRoot = note.pop();
            res.add(localRoot.data);
            localRoot = localRoot.right;
        }

    }

    // 层次遍历


    // 最大深度


    // 二叉树展开成链表



    /*
    * 搜索二叉树
    * 性质 左子树的值比根节点小 右子树的值都比根节点大
    * 中序遍历 得出的结果是 单调不减 (如果没有重复的值话就是单调递增的)
    * */
    //判断是否是搜索二叉树

    public boolean isSearch(TreeNode root)
    {
        ArrayList<Integer> notes = new ArrayList<>();
        inOrderNote(root,notes);
        for(int i = 0; i < notes.size() - 1; i++)
        {
            if(notes.get(i) > notes.get(i+1))
                return false;
        }
        return true;
    }
    public void inOrderNote(TreeNode root, ArrayList<Integer> notes)
    {
        if(root == null)
            return;
        inOrderNote(root.left,notes);
        notes.add(root.data);
        inOrderNote(root.right,notes);
    }

    /*完全二叉树性质
    *只能在叶子节点那一层缺失右子树
    *
    * */
    // 判断是否完全二叉树
    public boolean isWhole(TreeNode root)
    {
        if(root == null)
            return false;
        Queue<TreeNode> notes = new LinkedList<>();
        notes.add(root);
        while(!notes.isEmpty())
        {
            TreeNode tmp = notes.poll();
            if(tmp == null)
                break;
            notes.add(tmp.left);
            notes.add(tmp.right);
        }
        while(!notes.isEmpty())
        {
            if(notes.poll() != null)
                return false;
        }
        return true;
    }

    //公共祖先
    // 明确公共祖先的定义和条件
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root == null || root == q || root == p)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null)
            return null;
        if(left == null)
            return right;
        if(right == null)
            return left;
        return root;

    }

    // 根据中序遍历和先序遍历 建立二叉树


    // 树的子结构

    public boolean isSubTree(TreeNode rootA,TreeNode rootB)
    {
        return (rootA != null && rootB!= null) && (recur(rootA,rootB) || isSubTree(rootA.left,rootB)||isSubTree(rootA.right,rootB));
    }

    public boolean recur(TreeNode rootA, TreeNode rootB)
    {
        if(rootA == null)
            return false;
        if(rootB == null)
            return true;
        if(rootA.data != rootB.data)
            return false;
        return recur(rootA.left,rootB.left) && recur(rootB.right,rootB.right);
    }



    private boolean dfs(int[] postorder, int start, int end) {
        if (start >= end - 1)
            return true;
        // 根结点是最后一个元素
        int root = postorder[end - 1];
        // 左子树都比根结点小，右子树都比根结点大
        int i = start;
        while (i < end && postorder[i] < root)
            ++i;
        for (int j = i; j < end; ++j)
            if (postorder[j] < root)
                return false;
        return dfs(postorder, start, i) && dfs(postorder, i, end - 1);
    }

    // 判断是否是对称二叉树（镜像）
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null)
            return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode lf,TreeNode rt)
    {
        if(lf == null && rt == null)
            return true;
        if(lf == null || rt == null)
            return false;
        if(lf.data != rt.data)
            return false;
        return dfs(lf.left,rt.right) & dfs(lf.right,rt.left);
    }



}
