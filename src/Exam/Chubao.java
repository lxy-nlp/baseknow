package Exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Chubao {
    public static void main(String[] args)
    {
        String[] cards = {"SA","S3","S2","S5","S4"};
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
//        Arrays.sort(cards);
//        System.out.print(hasStraightFlush(cards));
    }



    public static boolean hasStraightFlush (String[] cards) {
        // write code here
//        Arrays.sort(cards);
        char col = cards[0].charAt(0);
        int[] nums = new int[cards.length];
        int[] nums1 = new int[cards.length];
        HashMap<String,Integer> map = new HashMap();
        for(int i = 2; i < 11; i++)
            map.put(i+"",i);
        map.put("A",1);
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        int i = 0;
        int j = 0;
        for(String s : cards)
        {
            char color = s.charAt(0);
            if(color != col)
                return false;
            String num = s.substring(1);
            if(num.equals("A"))
                nums1[j++] = 14;
            else
                nums1[j++] = map.get(num);
            nums[i++] = map.get(num);

        }

        int[] dp = new int[cards.length];
        Arrays.fill(dp,1);
        int maxlen1 = 1;
        Arrays.sort(nums);
        for(int t = 1; t < cards.length; t++)
        {
            if(nums[t] - nums[t-1] == 1)
            {
                dp[t] = dp[t-1] + 1;
                maxlen1 = Math.max(dp[t],maxlen1);
            }
        }
        int maxlen2 = 1;
        int[] dp1 = new int[cards.length];
        Arrays.fill(dp1,1);
        Arrays.sort(nums1);
        for(int t = 1; t < cards.length; t++)
        {
            if(nums1[t] - nums1[t-1] == 1)
            {
                dp[t] = dp[t-1] + 1;
                maxlen2 = Math.max(dp1[t],maxlen2);

            }
        }
//        Integer.valueOf()

        HashMap<Integer,String> t = new HashMap<>();
        return maxlen1 > 4 || maxlen2 > 4;
    }



    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("") || s == null)
            return 0;
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet();
        set.add(arr[0]);
        HashMap<Character,Integer> map = new HashMap();
        int[] dp = new int[s.length()];
        Arrays.fill(dp,1);
        int maxlen = 1;
        map.put(arr[0],0);
        int left = 0;
        for(int i = 1; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                dp[i] = i-left;
                left = i;
            }
            else
            {
                dp[i] = dp[i-1] + 1;

            }
            maxlen = Math.max(dp[i],maxlen);
            map.put(arr[i],i);
        }
        return maxlen;
    }
}
