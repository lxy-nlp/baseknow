package Exam;

import java.util.Scanner;



import java.util.Scanner;
import java.util.LinkedList;
public class Shence {
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            // LinkedList<String> origin = new LinkedList();
            String ss = sc.next();
            String[] str = ss.split("\n");
            LinkedList<String> origin = new LinkedList();
            for(String t : str)
            {
                if(t != "" && t != "\n")
                    origin.add(t);
            }
            LinkedList<String> res = removeComment(origin);
            String ans = "";
            for(String s : res)
            {
                ans += s;
            }
            System.out.println(ans);
        }
        public static LinkedList<String> removeComment(LinkedList<String> origin)
        {
            int up = -1, down =-1;
            LinkedList<String> newst = new LinkedList(origin);
            for(int j = 0; j < origin.size(); j++)
            {
                String s = origin.get(j);
                for(int i = 0; i < s.length() - 1;i++)
                {
                    if(s.charAt(i) == '<' && s.charAt(i+1) == '>')
                    {
                        newst.set(j,s.substring(0,i).trim());
                        break;
                    }
                    else if(s.charAt(i)== '<' && s.charAt(i+1) == '<')
                    {
                        up = j;
                        break;
                    }
                    else if(s.charAt(i) == '>' && s.charAt(i+1) == '>')
                    {
                        down = j;
                        while(down >= up && up >=0)
                        {
                            newst.remove(up);
                            up++;
                        }
                        up = -1;
                        down =-1;
                        break;
                    }
                }
            }
            return newst;
        }
    }

