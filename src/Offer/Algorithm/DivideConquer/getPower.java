package Offer.Algorithm.DivideConquer;

public class getPower {
    public static int power(int x,int n)
    {
        /**
         * x 是 底
         * n 是 指数
         * 相较于传统递归 时间复杂度降低 O(log2N)
         */
        int result = 0;
        if(n == 0)
            return 1;
        if(n == 1)
        {
            return x;
        }
        if(n % 2 == 0)
        {
            result = power(x, n /2) * power(x,n / 2);
        }
        else
        {
            result = power(x,(n+1) /2) * power(x,(n-1)/2);
        }
        return result;
    }
    public static void main(String[] args)
    {
        int l1 = power(2,3);
        int l2 = power(2,4);
        System.out.print(l1);
        System.out.print(l2);
    }
}
