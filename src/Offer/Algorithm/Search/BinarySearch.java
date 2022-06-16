package Offer.Algorithm.Search;


// 二分查找
/*
* 通常在有序数组中使用
* 下面是二分的递归和迭代解法
* 在没找到的情况下 返回小于这个数的个数
*
* */
public class BinarySearch {

    public int rank(int[] arr,int lo,int hi,int target)
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
}
