package Offer.Algorithm.Sort;

import java.util.ArrayList;
import java.util.Collections;

// 桶排序
public class BucketSort {
    public static void sort(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }
        // 计算桶的数量
        int k = (max-min) / arr.length +1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for(int i = 0; i < k;i++)
        {
            bucketArr.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++)
        {
            int num = (arr[i] - min) / arr.length;
            bucketArr.get(num).add(arr[i]);
        }
        for(int i = 0; i < k; i++)
        {
            Collections.sort(bucketArr.get(i));
        }
        int index = 0;
        for(int i = 0; i < k;i++)
        {
            for(int j = 0; j < bucketArr.get(i).size();j++)
            {
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }
}
