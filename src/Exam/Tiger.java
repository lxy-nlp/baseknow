package Exam;

public class Tiger {
    public static void main(String[] args)
    {
        int[] test = {1,2,3};
        System.out.print(profit(test));
    }
    public static int profit(int[] nums)
    {
        int m = nums.length;
        int count = 0;
        for(int i = 0; i < m-1; i++)
        {
            for(int j = i+1; j < m; j++)
            {
                if(nums[j] > nums[i])
                    count++;
            }
        }
        return count;
    }

    // grid的最短路径
    // 链表 两数相加

}
