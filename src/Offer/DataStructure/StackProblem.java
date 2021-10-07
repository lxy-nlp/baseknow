package Offer.DataStructure;

import java.util.*;

// 括号内的字符串反转
// 来自 华为实习生 笔试 & Leetcode
public class StackProblem {


    public static String reverse(String s)
    {
        Stack<String> note = new Stack();
        int i = 0;
        LinkedList<String> res = new LinkedList();
        while(i < s.length())
        {
            if(s.charAt(i) != ')')
            {
                note.push(s.substring(i,i+1));
            }
            else
            {
                while( !note.isEmpty() )
                {
                    if(!note.peek().equals("("))
                        res.add(note.pop());
                    else
                    {
                        note.pop();
                        break;
                    }
                }
                while(!note.isEmpty() && !res.isEmpty())
                {
                    note.push(res.removeLast());
                }
            }
            i++;
        }
        String result = "";
        for(String tt:res)
            result += tt;
        return result;
    }

    // topK问题
    public static void topKfrequency(int[] nums,int k)
    {
        int[] result = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num,map.getOrDefault(num,0) + 1);
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer,Integer>> queue =
                new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());

        // 构建小根堆 queue中只保留k个元素
        for(Map.Entry<Integer,Integer> entry : entries)
        {
            queue.offer(entry);
            if(queue.size() > k)
                queue.poll();
        }
    }

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(char c : arr)
        {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else
            {
                if(!stack.isEmpty())
                {
                    if((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}' ) || (stack.peek() == '[' && c== ']'))
                        stack.pop();
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }




    public static void main(String[] args) {
//        boolean res = isValid("{}()");
//        System.out.print(res);
    }
}
