package Offer.JianZhi;

public class Chapter3 {
    // 将奇数放到偶数前面
    // 下面是解耦的做法
    public void Reorder(int[] arr,int length)
    {
        if(arr == null || length == 0)
            return;
        int start = 0,high = length - 1;
        while(start < high)
        {
            while(start < high && !isEven(arr[start]))
            {
                start++;
            }
            while(start < high && isEven(arr[high]))
            {
                high--;
            }
            if(start < high)
            {
                swap(arr,start,high);
            }
        }
    }
    public boolean isEven(int num)
    {
        return (num&1) == 0; //判断奇数偶数
    }
    public void swap(int[] arr,int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static double PowerWithUnsignedExponent(double base,int exponent)
    {
        //bases是底数 exponent是指数
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result = PowerWithUnsignedExponent(base,exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    public static void main(String[] args)
    {
        double res = PowerWithUnsignedExponent(2,5);
        System.out.print(res);
    }
}
