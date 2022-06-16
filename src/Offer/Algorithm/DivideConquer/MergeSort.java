package Offer.Algorithm.DivideConquer;

public class MergeSort {
    /*归并排序的本质是 通过多次 分割 然后合并 达到排序的效果*/
    public static void mergesort(int[] arr)
    {
        int[] tmp = new int[arr.length]; // 辅助数组
        sort(arr,0,arr.length-1,tmp);
    }
    public static void sort(int[] arr,int left,int right,int[] tmp)
    {
        if(left >= right)
            return;
        if(left < right)
        {
            int mid = (left + right) / 2;
            sort(arr,left,mid,tmp);
            sort(arr,mid+1,right,tmp);
            merge(arr,left,mid,right,tmp);
        }
    }
    //合并两个有序数据
    public static void merge(int[] arr,int left,int mid,int right,int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid)
        {
            tmp[t++] = arr[i++];
        }
        while(j<=right)
        {
            tmp[t++] = arr[j++];
        }
        t = 0;
        while(left<=right)
        {
            arr[left++] = tmp[t++];
        }
    }
}
