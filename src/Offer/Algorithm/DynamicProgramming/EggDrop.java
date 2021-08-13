package Offer.Algorithm.DynamicProgramming;

import java.util.Arrays;

public class EggDrop {
    public int countdrop(int k,int n)
    {
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i < n;i++)
            Arrays.fill(dp[i],i);
        for(int i = 0; i < n+1; i++)
        {
            dp[i][1] = i;
            dp[i][0] = 0;
        }
        for(int i = 0; i <=k;i++)
        {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        dp[1][0] = 0;

        for(int i = 2; i < n;i++)
        {
            for(int j= 2; j <k;j++)
            {
                for(int t = 1;t <= i;t++)
                {
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[t-1][j-1],dp[i-t][j])+1);
                }
            }
        }

        // 二分减少时间复杂度
        for(int i = 2; i < n;i++)
        {
            for(int j= 2; j <k;j++)
            {
                int left=1, right= i;
                while(left < right)
                {
                    int mid = (right + left) / 2;
                    int breakCount = dp[mid -1][j -1];
                    int notBreakCount = dp[i - mid][j];
                    if(breakCount > notBreakCount)
                        right = mid - 1;
                    else
                        left = mid;
                }
                dp[i][j] = Math.max(dp[left - 1][j - 1],dp[i - left][j]) +1;

            }
        }

        return dp[n][k];
    }

}
