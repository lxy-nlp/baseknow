package Offer.Algorithm.Backward;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SumOfThree {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> val = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track,val,res);
        return res;
    }
    public static void backtrack(int[] nums, LinkedList<Integer> track,LinkedList<Integer> val,  List<List<Integer>> res )
    {
        if(val.size() == 3)
        {
            long sum = val.stream().reduce(Integer::sum).orElse(0);
            if(sum == 0)
            {
                Collections.sort(val);
                if(!res.contains(val))
                    res.add(new LinkedList<>(val));
            }
            return;
        }
        for(int i = 0;i < nums.length;i++)
        {
            if(track.contains(i))
                continue;
            track.add(i);
            val.add(nums[i]);
            backtrack(nums,track,val,res);
            track.removeLast();
            val.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> res = threeSum(nums);
        System.out.print(res);
    }
}