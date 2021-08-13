
import java.util.*;


public class TEST {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public static int longestValidParentheses (String s) {
        // write code here
        if(s.length() < 2)
            return 0;
        char[] arr = s.toCharArray();
        LinkedList<Character> notes = new LinkedList();
        notes.add(arr[0]);
        int len = 0;
        for(int i = 1; i < arr.length; i++)
        {
            if(notes.size() > 0 && notes.getFirst() == '(' && arr[i] == ')')
            {
                len += 2;
                notes.removeFirst();
            }
            else
            {
                if(arr[i] == '(')
                    notes.addFirst(arr[i]);
            }
        }
        return len;
    }
    public static void main(String[] args)
    {
        System.out.println("is "+10+5);
        System.out.println("is "+(10+5));

    }
}