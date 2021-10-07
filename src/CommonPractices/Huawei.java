package CommonPractices;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Huawei {
    public static void main(String[] args)
    {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0; i < n;i++)
//        {
//            nums[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();
//        boolean res = canJump(nums);
//        if(!res)
//            System.out.println(-1);
//        int least = leastJump(nums);
//        if(least <= k)
//            System.out.println(least);
//        else
//            System.out.println(-1);
        int[] nums = {1,4,2000};
        int res = maxArea(nums);
        System.out.println(res);
    }
    public static int leastJump(int[] nums)
    {
        int step = 0;
        int cover = 0;
        int next = 0;
        for(int i = 0; i < nums.length;i++)
        {
            if(cover < i)
            {
                step++;
                cover = next;
            }
            next = Math.max(next,i + nums[i]);
        }
        return step;
    }
    // 跳跃游戏
    public static boolean canJump(int[] nums)
    {
        int cover = 0;
        if(nums.length == 1)
            return true;
        for(int i = 0; i <= cover; i++)
        {
            cover = Math.max(cover,nums[i] + i);
            if(cover > nums.length)
                return true;
        }
        return false;
    }


    public static int maxArea(int[] nums)
    {

        int area = 0;
        for(int i = 0;i < nums.length - 1;i++)
        {
            int max = nums[i],min = nums[i],maxIndex = i,minIndex = i;
            for(int j = i+1; j < nums.length;j++)
            {
                if(nums[j] > max)
                {
                    max = nums[j];
                    maxIndex = j;
                }
                if(nums[j] < min)
                {
                    min = nums[j];
                    minIndex = j;
                }
                System.out.println("maxIndex:" + maxIndex + " minIndex :"+minIndex);
                int tmp = ((Math.abs(maxIndex - minIndex)+1) * (max - min)) % 1000000007;
                System.out.println(tmp);
                area += tmp;
                area = area % 1000000007;
            }
        }
        return area;
    }
}
