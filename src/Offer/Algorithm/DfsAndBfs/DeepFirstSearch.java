package Offer.Algorithm.DfsAndBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepFirstSearch {
    // 括号生成

    /*
    * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能
    * 的并且 有效的 括号组合。
    * 示例 1：
    * 输入：n = 3
    * 输出：["((()))","(()())","(())()","()(())","()()()"]
    * */
    public static List<String> generateParenthesis(int n)
    {
        List<String> res = new LinkedList<String>();
        dfs(n,n,"",res);
        return res;
    }

    public static void dfs(int left, int right,String s,List<String> res)
    {
        if(left > right)
            return;
        if(left == 0 && right == 0)
        {
            res.add(s);
            return;
        }
        if(left > 0)
        {
            dfs(left - 1,right,s + "(",res);
        }
        if(right > 0)
        {
            dfs(left,right-1,s+")",res);
        }
    }


    // 岛屿问题 其思想本质是DFS 细节是边界问题 和 dfs的返回值
    /*
    * 岛屿问题主要分为以下几类
    * 1. 岛屿周长
    * 2. 岛屿面积
    * 3. 岛屿数量
    * */
    class ZhouChang {
        int m = 0, n = 0;
        public int islandPerimeter(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n;j++)
                {
                    if(grid[i][j] == 1)
                    {
                        return dfs(grid,i,j);
                    }
                }
            }
            return 0;
        }
        public int dfs(int[][] grid,int row,int col)
        {
            if(!inArea(grid,row,col) || grid[row][col] == 0)
                return 1;
            if(grid[row][col] != 1)
                return 0;
            grid[row][col] = 2;
            return dfs(grid,row+1,col) + dfs(grid,row-1,col)+ dfs(grid,row,col-1)+dfs(grid,row,col+1);

        }
        public boolean inArea(int[][] grid, int row,int col)
        {
            if(row < 0 || row > m - 1 || col < 0 || col > n-1)
                return false;
            return true;
        }
    }



    // 课程依赖问题　文件编译依赖问题
    /*
    * 两种解法　
    * 深度优先　检测图是否有环　和广度优先
    * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i)) return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(Integer j : adjacency.get(i))
            if(!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }
    public boolean canFinish１(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }


    public static void main(String[] args)
    {

    }


}
