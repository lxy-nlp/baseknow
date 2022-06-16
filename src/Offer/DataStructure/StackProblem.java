package Offer.DataStructure;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

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

    public static void main(String[] args) {
        String res = reverse("(u(evol)i)");
        System.out.print(res);
    }
}
