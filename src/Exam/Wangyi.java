//package Exam;
//
//public class Wangyi {
//
//    public static int[][] dp;
//    public static int m , n;
//    public static void main(String[] args)
//    {
//
//    }
//
//    public static void minProfit(int[][] grids)
//    {
//        m = grids.length,;
//        n = grids[0].length;
//        dp = new int[m+1][n+1];
//
//        dp[0][0] = grids[0][0];
//        dp[0][1] = grids[0][1];
//        dp[1][0] = grids[1][0];
//        for(int i = 1; i < m+1; i++)
//        {
//            for(int j = 1; j < n+1; j++)
//            {
//                int left = dp[i][j-1];
//                int right = dp[i][j+1];
//                int up = dp[i+1][j];
//                int down = dp[i-1][j];
////                dp[i][j] +=
//            }
//        }
//
//    }
//
//    public static int dfs(int[][] grids, int row ,int  col)
//    {
//        if(row < 0 || row > m -1 || col < 0 || col > n-1 || grids[row][col] == 0)
//            return 0;
//        int t = grids[row][col];
//        grids[row][col] = 0;
//
//
//
//
//    }
//}
