package Offer.DataStructure;

import java.util.LinkedList;
import java.util.List;

public class StringProblem {

    // 回文子串
    // 最长回文子串
    public String longestString(String s)
    {
        char[] arr = s.toCharArray();
        int start = 0, end = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int len1 = extend(arr,i,i);
            int len2 = extend(arr,i,i+1);
            int len = Math.max(len1,len2);
            if(len > (end - start))
            {
                start = i - (len -1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);
    }


    // 回文子串的个数
    public int countString(String s)
    {
        int count = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            count += extend(arr,i,i);
            count += extend(arr,i,i+1);
        }
        return count;
    }

    // 中心扩展法
    public int extend(char[] s,int i,int j)
    {
        int res = 0;
        while(i >= 0 && j <s.length && s[i] == s[j])
        {
            i--;
            j++;
            res++;
        }
        return j - i + 1;
        // return res;
    }

    // 替换空格
//    public String altitude(String s)
//    {
//
//    }

    public static List<List<String>> res = new LinkedList<>();
    public static LinkedList<String> tmp = new LinkedList<>();
    String str;

    // 分割回文子串
    // 回溯
    public List<List<String>> partition(String s)
    {
        str = s;
        char[] arr = s.toCharArray();
        backward(arr,0);
        return res;
    }
    public void backward(char[] arr, int index)
    {
        if(index >= arr.length)
        {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for(int i = index; i < arr.length; i++)
        {
            if(!isPalindrome(arr,index,i))
                continue;
            tmp.add(str.substring(index,i+1));
            backward(arr,i+1);
            tmp.removeLast();
        }
    }

    public boolean isPalindrome(char[] arr, int left, int right)
    {
        while(left < right)
        {
            if(arr[left] != arr[right])
                return false;
            left++;
            right--;
        }
        return true;

    }


    // 无重复最长子串
//    public String noRepeatString(String s)
//    {
//
//    }

    //

}
