package Offer.Algorithm.DynamicProgramming;

// 背包问题
/*
* 0-1背包
* 完全背包
* 分割子集
* */
public class Check {
    // 找零钱问题
    /*
    *   一种是纸币可以重复使用
    *   另一种是 只能用一次
    * */
    public int minCoins1(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];
        // 矩阵初始状态赋值
        for(int j = 1; j < aim;j++)
        {
            dp[0][j] = max;
            if(j -arr[0] >= 0 && dp[0][j-arr[0]] != max)
            {
                dp[0][j] = dp[0][j-arr[0]] +1;
            }
        }
        int left = 0;
        for(int i = 1;i < n;i++)
        {
            for(int j = 1;j <= aim;j++)
            {
                left = max;
                if(j - arr[i] >= 0 && dp[i][j - arr[i]] != max)
                {
                    left = dp[i][j-arr[i]] +1;
                }
                dp[i][j] =Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }
    // 问题的空间优化
    /*动态规划中的空间压缩问题*/
    public int minCoinOptimize(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim+1];
        for(int j =1;j <= aim;j++)
        {
            dp[j] = max;
            if(j - arr[0] >= 0 && dp[j-arr[0]] != max)
            {
                dp[j] = dp[j-arr[0]] + 1;
            }
        }

        int left = 0;
        for(int i = 1; i < arr.length;i++)
        {
            for(int j = 1; j < aim+1; j++)
            {
                left = max;
                if(j-arr[i] >= 0 && dp[j -arr[0]] != max)
                {
                    left = dp[j-arr[0]] + 1;
                }
                dp[j] = Math.min(left,dp[j]); // 因为只有一列在更新了所以这里不能直接赋值 得 选择最小的

            }
        }
        return dp[aim] == max ? -1 : dp[aim];
    }
    public int minCoinsUn(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];
        for(int j = 1; j <= aim; j++)
        {
            dp[0][j] = max;
        }
        if(arr[0] <= aim)
        {
            dp[0][arr[0]] = 1;
        }
        int leftup = 0;
        for(int i = 1;i<n;i++)
        {
            for(int j =1;j <= aim;j++)
            {
                leftup = max;
                if(j -arr[i] >= 0 && dp[i-1][j-arr[i]] != max)
                {
                    leftup = dp[i-1][j-arr[i]] +1;
                }
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }


    // 空间优化的解法
    public int minCoinUndeOptimize(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n= arr.length;
        int[] dp = new int[aim+1];
        int max = Integer.MAX_VALUE;
        for(int j = 1; j < aim+1;j++)
        {
            dp[j] = max;
        }
        if(arr[0] <= aim)
            dp[arr[0]] = 1;
        int leftup = 0;
        for(int i = 1;i < n;i++)
        {
            for(int j = aim; j >0;j++)
            {
                leftup = max;
                if(j - arr[i] >= 0 && dp[j - arr[i]] != max)
                {
                    leftup = dp[j-arr[i]] + 1;
                }
                dp[j] = Math.min(leftup,dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }



    // 找零钱的方法数
    /*
    * 提供四种方法
    * 1. 暴力递归
    * 2. 记忆搜索
    * 3. 动态规划
    * 4. 动态规划空间压缩版本
    * */
    // 暴力递归
    public int coins1(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;
        return process1(arr,0,aim);
    }
    public int process1(int[] arr,int index,int aim)
    {
        int res = 0;
        if(index == arr.length)
        {
            res = aim == 0 ? 1:0;
        }
        else
        {
            for(int i = 0;arr[index] * i <= aim;i++)
            {
                res += process1(arr,index+1,aim-arr[index] * i);
            }
        }
        return res;
    }
    // 记忆搜索法
    public int coins2(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;

        int[][] map = new int[arr.length][aim+1];
        return process2(arr,0,aim,map);
    }
    public int process2(int[] arr,int index,int aim,int[][] map)
    {
        int res = 0;
        if(index == arr.length)
        {
            res = aim == 0 ? 1:0;
        }
        else
        {
            int mapValue = 0;
            for(int i = 0;arr[index] * i <= aim;i++)
            {
                mapValue = map[index+1][aim-arr[i] * i];
                if(mapValue != 0)
                    res += mapValue == -1 ? 0:mapValue;
                else
                    res += process2(arr,index+1,aim-arr[index] * i,map);
            }
        }
        map[index][aim] = res == 0 ? -1:res;
        return res;
    }

    public int coins3(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim+1];
        for(int i = 0; i < arr.length;i++)
            dp[i][0] = 1;
        for(int j = 1;arr[0] * j <= aim;j++)
            dp[0][arr[0] *j] =1;
        int num = 0;
        for(int i = 1; i < arr.length;i++)
        {
            for(int j = 1; j <= aim;j++)
            {
                num = 0;
                for(int k = 0; j -arr[i] * k >= 0;k++)
                {
                    num += dp[i-1][j-arr[i]*k];
                }
                dp[i][j] = num;



            }
        }
        return dp[arr.length -1][aim];
    }
    public int coins4(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim+1];
        for(int i = 0;i < arr.length;i++)
            dp[i][0] = 1;
        for(int j = 1;arr[0] * j <= aim;j++)
            dp[0][arr[0]*j] = 1;
        for(int i = 1; i < arr.length;i++)
        {
            for(int j =1;j <= aim;j++)
            {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j-arr[i] >= 0 ? dp[i][j-arr[i]] : 0;
            }
        }
        return dp[arr.length -1][aim];
    }

    public int coins5(int[] arr,int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[] dp = new int[aim+1];
        for(int j = 1;arr[0] * j <= aim;j++)
            dp[arr[0]*j] = 1;
        for(int i = 1; i < arr.length;i++)
        {
            for(int j = 1; j <= aim; j++)
            {
                dp[j] += j -arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }



}
