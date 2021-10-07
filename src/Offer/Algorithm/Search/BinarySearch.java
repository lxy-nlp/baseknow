package Offer.Algorithm.Search;


// 二分查找
/*
* 通常在有序数组中使用
* 下面是二分的递归和迭代解法
* 在没找到的情况下 返回小于这个数的个数
*
* */
public class BinarySearch {
    public static void main(String args[]){
        int[] arr = {2,3,4,5,7,8,9};
        int res = targetPosition(arr,5);
        System.out.print(commonBinary(arr,5));
        System.out.print(res);
    }

    public static int rank(int[] arr,int lo,int hi,int target)
    {
        if(hi < lo) return lo;
        int mid = (lo + hi) /2;
        if(arr[mid] > target)
            return rank(arr,lo,mid - 1,target);
        else if(arr[mid] < target)
            return rank(arr,mid+1,hi, target);
        else
            return mid;
    }

    public int rank(int[] arr,int target)
    {
        int lo = 0,hi = arr.length - 1;
        int mid = (lo + hi) /2;
        while(lo <= hi)
        {
            if(arr[mid] > target)
                return rank(arr,lo,mid - 1,target);
            else if(arr[mid] < target)
                return rank(arr,mid+1,hi, target);
            else
                return mid;
        }
        return lo;
    }
    // 常规二分查找
    public static int commonBinary(int[] arr,int target)
    {
        int left = 0, right = arr.length - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // 寻找目标的插入位置
    public static int targetPosition(int[] arr, int target)
    {
        int left = 0, right = arr.length -1;
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(arr[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
