package Offer.Algorithm.Backward;

import java.util.LinkedList;
import java.util.List;

// 深度搜索
 /*
 * */
public class DFS {
    public static List<String> res = new LinkedList();

    public static void main(String[] args)
    {
        System.out.print(generateParenthesis(3));
    }
    // 括号生成问题
    public static List<String> generateParenthesis(int n) {
        if(n == 0)
            return res;
        dfs("",n,n);
        return res;
    }
    public static void dfs(String s, int left, int right)
    {
        if(left == 0 && right ==0)
            res.add(s);
        if(left > right)
            return;
        System.out.println("------------"+ s);
        if(left > 0)
            dfs(s+"(",left-1,right);
        if(right > 0)
            dfs(s+")",left,right-1);
    }










}
