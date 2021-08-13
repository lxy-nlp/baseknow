package Offer.Algorithm.DynamicProgramming;

import java.util.Arrays;

public class SequenceProblem {
    public static void main(String[] args) {

    }
    //
    public int lengthOfLIS(int[] nums)
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.length;i++)
        {
            for(int j = 0;j < i;j++)
            {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int res = 0;
        for(int k = 0;k < dp.length;k++)
        {
            res = Math.max(res,dp[k]);
        }
        return res;
    }

    //
    public static int LCS(String s1, String s2)
    {
        char[] as1 = s1.toCharArray();
        char[] as2 = s2.toCharArray();
        int m = as1.length,n=as2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m; i++)
        {
            for(int j = 1; j < n;j++)
            {
                if(as1[i-1] == as2[j-1])
                {
                    dp[i][j] = dp[i-1][j-1] +1;

                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
    //
    public static int LCSS(String s1,String s2)
    {
        char[] as1 = s1.toCharArray();
        char[] as2 = s2.toCharArray();
        int m = as1.length,n = as2.length,res = 0;
        int[][] dp = new int[m][n];
        for(int i = 1;i < m;i++)
        {
            for(int j = 1;j < n;j++)
                if(as1[i] == as2[j])
                {
                    dp[i][j] = dp[i-1][j-1] +1;
                    res = Math.max(res,dp[i][j]);
                }
        }
        return res;

    }
}
