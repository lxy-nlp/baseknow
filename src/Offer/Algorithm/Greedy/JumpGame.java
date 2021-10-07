package Offer.Algorithm.Greedy;

public class JumpGame {
    public static void main(String[] args)
    {
        int[] nums = {2,3,1,1,4};
        int ans = leastJump(nums);
        System.out.println(ans);

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

    // 最少的跳跃次数
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


}
