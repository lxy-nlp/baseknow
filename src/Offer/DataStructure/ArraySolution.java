package Offer.DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArraySolution{
    public static void main(String[] args) {

    }
    // 二分查找

    /*
    * 请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：
    每一行的数字都从左到右排序
    每一行的第一个数字都比上一行最后一个数字大
    例如：
    对于下面的矩阵：
    [
        [1,   3,  5,  9],
        [10, 11, 12, 30],
        [230, 300, 350, 500]
    ]
    * */
    public boolean searchMatrix (int[][] matrix, int target) {
        // write code here

        int m = matrix.length;
        if(m==0)
            return false;
        int n = matrix[0].length;
        int low = 0,high = n - 1;
        int mid =0;
        int key=-1;
        for(int i = 0; i < m;i++)
        {
            if((matrix[i][0] <= target) && (matrix[i][n-1] >=target))
            {
                key = i;
                break;
            }

        }
        if(key < 0)
            return false;

        while(low <= high)
        {
            mid = (low + high) /2;
            if(matrix[key][mid] > target)
                high = mid -1;
            else if(matrix[key][mid] < target)
                low = mid + 1;
            else
                return true;
        }
        return false;
    }
    /*
    * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
        示例1
        输入
        复制
        [[1,2,3],[4,5,6],[7,8,9]]
        返回值
        复制
        [1,2,3,6,9,8,7,4,5]
    * */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length < 1)
            return res;
        int top = 0,bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length -1;
        while(top < (matrix.length + 1) /2 && left < (matrix[0].length + 1)/2)
        {
            for(int i = left; i <= right;i++)
                res.add(matrix[top][i]);

            for(int i = top + 1; i <= bottom; i++)
                res.add(matrix[i][right]);

            for(int i = right-1;top != bottom && i >= left;i--)
                res.add(matrix[bottom][i]);

            for(int i = bottom -1; left != right && i >= top+1;i--)
                res.add(matrix[i][left]);

            ++top;
            ++left;
            --bottom;
            --right;
        }
        return res;
    }
    /**
     * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
     * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
     * 假设给出的数组中只存在唯一解
     * 例如：
     * 给出的数组为 {20, 70, 110, 150},目标值为90
     * 输出 index1=1, index2=2
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        for(int i = 0;i< numbers.length-1;i++)
        {
            for(int j = i+1;j < numbers.length;j++)
            {
                if(numbers[i] + numbers[j] == target)
                {
                    res[0] = i+1;
                    res[1] = j+1;
                    break;
                }
            }
        }
        return res;
    }

    /*
    * 合并有序数组
    * */
    public void merge(int A[], int m, int B[], int n) {
        int total = m + n -1;
        int i = m-1,j= n-1;
        while(i >= 0 && j >= 0)
        {
            if(A[i] >= B[j])
            {
                A[total] = A[i];
                total--;
                i--;
            }
            else if(A[i] < B[j])
            {
                A[total] = B[j];
                total--;
                j--;
            }
        }
        if(i >= 0)
        {
            int t = i;
            while(t >= 0 )
            {
                A[total] = A[t];
                t--;
                total --;
            }
        }
        if(j >= 0)
        {
            int t = j;
            while(t >= 0)
            {
                A[total] = B[t];
                t--;
                total --;
            }
        }
    }


/*
*
    给出一组区间，请合并所有重叠的区间。
    请保证合并后的区间按区间起点升序排列。
    示例1
    输入
    复制
    [[10,30],[20,60],[80,100],[150,180]]
    返回值
    复制
    [[10,60],[80,100],[150,180]]
* */
 class Interval {
        int start;
        int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // 第一步先按照右值排序
        for(int i = 0; i < intervals.size() -1; i++)
        {
            Interval min = intervals.get(i);
            int min_index = i;
            for(int j = i+1; j < intervals.size();j++)
            {
                if(intervals.get(j).end < min.end)
                {
                    min = intervals.get(j);
                    min_index = j;
                }
            }
            intervals.set(min_index,intervals.get(i));
            intervals.set(i,min);

        }

        for(int k = intervals.size() -1; k > 0  ;k--)
        {
            if(intervals.get(k).start <= intervals.get(k-1).end)
            {
                if(intervals.get(k).start <= intervals.get(k-1).start)
                {
                    intervals.remove(k-1);
                }
                else if(intervals.get(k).start > intervals.get(k-1).start)
                {
                    intervals.get(k).start = intervals.get(k-1).start;
                    intervals.remove(k-1);
                }
            }
        }

        return intervals;

    }

    /*
    * 题目描述
        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
        示例1
        输入
        [1,2,3,2,2,2,5,4,2]
        返回值
        2
    * */
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> a = new HashMap<>();
        for(int i = 0; i < array.length;  i++)
        {
            if(a.containsKey(array[i]))
            {
                int count = a.get(array[i]) + 1;
                a.replace(array[i],count);

            }
            else
                a.put(array[i],1);

            if(a.get(array[i]) > array.length / 2)
                return array[i];
        }
        return 0;
    }

    /*
    * 山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
      假设 nums[-1] = nums[n] = -∞。
    * */
    public int solve (int[] a) {
        // write code here
        if(a.length < 3)
            return -1;
        if(a[a.length - 1] > a[a.length - 2])
            return a.length - 1;
        for(int point = a.length -2; point >= 0; point--)
        {
            if((a[point] >= a[point-1]) && (a[point] >= a[point+1]))
                return point;
        }
        return -1;
    }

    /*
    给定一个double类型的数组arr，其中的元素可正可负可0，
    返回子数组累乘的最大乘积。

    我的解题思路是:第一个数字开始 每次都向后乘一个数字,如果结果大于现在的max那么替换i
    * */
    public double maxProduct(double[] arr) {
        int count = (arr.length + 1)*arr.length /2;
        double[] a = new double[count];
        double max = arr[0];
        int t = 0;
        for(int i = 0; i < arr.length; i++)
        {
            a[t] = arr[i];
            if(max < a[t])
                max = a[t];
            for(int j = i+1 ;j < arr.length; j++)
            {
                a[t+1] = a[t] *arr[j];
                if(max < a[t+1])
                    max = a[t+1];
                t++;
            }

        }
        return max;
    }
    // 二分查找

}