package Exam;

import java.util.*;
public class Meituan{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if(s.length() < 2)
            System.out.println(0);
        else
        {
            int count = 0;
            for(int i = 0; i < s.length() - 1;i++){
                for(int j = i+1;j < s.length();j++){
                    String tmp = s.substring(i,j+1);
                    long t = Long.valueOf(tmp);
                    if(!isTwo(tmp) || t< 22)
                        continue;
                    if(t % 22 == 0){
                        count++;
                    }


LinkedList<Integer> list = new LinkedList<>();
                    list.remove()
                }
            }
            System.out.println(count);
        }
    }
    public static boolean isTwo(String s)
    {
        if(s.charAt(s.length() - 1) == '0' ||s.charAt(s.length() - 1) == '2' || s.charAt(s.length() - 1) == '4'
                ||s.charAt(s.length() - 1) == '6'||s.charAt(s.length() - 1) == '8')
            return true;
        else
            return false;
    }
}

/*
*
* 整除
时间限制： 5000MS
内存限制： 655360KB
题目描述：
小美最近迷上了22这个数字，一天，她发现他的一本书中有一个神秘的大数字。于是她想知道这个数字中有多少子串代表的数字能被22整除。



输入描述
一行一个只由数字组成的不含前导零的字符串，字符串长度为 n(1≤n≤105)。

输出描述
一行一个整数代表有多少这个字符串的子串代表的数字能被 22 整除。
*
*
*
* 小美所在的城市有很多地铁站，地铁站之间由线路直接连接，组成了一个地铁网络。一天她突发奇想，把若干个地铁站的编号依次进行交换。请问在所有的交换结束之后，每个编号指向的地铁站直接相连接的地铁站一共有多少个？

两个地铁站之间可能有多条线路直接连接。但是不存在直接指向自己的线路。



输入描述
第一行三个数字n,m,q(1≤n,m,q≤105)，分别代表地铁站数量，直接连接的地铁路数量，交换数量。

接下来m行每行两个数字u,v(1≤u,v≤n)代表直接连接的两个地铁站编号。

接下来q行每行两个数字x,y(1≤x,y≤n)代表你要交换的两个点编号。

数字间均有空格隔开

输出描述
一行n个空格隔开的数字，每个数字代表与对应编号直接相连的地铁站一共多少个。
*
*
*
* 小美在听歌。歌单给小美推送了一个歌单序列，歌单中的歌会严格按顺序播放。

歌单中有很多歌曲，听每首歌曲会给小美带来ai点愉悦值。但是某些歌曲是一个系列的。如果小美在听这首歌曲之前没有按顺序听过这个系列的所有前面的歌曲，就会给小美带来-bi的愉悦值（即最后选择这首歌可获得的总愉悦值为ai-bi。）歌单并不会保证这首歌在系列中前面的歌曲都在歌单中。

因此，小美可以预先去除中间的一些歌曲，使得自己更加愉悦。由于去掉歌曲需要花费时间，所以每去掉一首歌曲都会让自己的愉悦值减小k。

由于歌单是智能的，所以其中不会包含重复的歌曲。

请问小美能获得的最大愉悦值是多少？



输入描述
第一行两个空格隔开的整数n,k(1≤n,k≤105)代表歌曲数量和删除歌曲减少的愉悦值。

接下来n行每行包括四个空格隔开的整数ai,bi,ci,di(1≤ai,bi,ci,di≤105)分别代表听这首歌获得的愉悦值，没有按顺序听完这个系列之前的歌所需要扣除的愉悦值，这首歌所在的系列，这首歌在系列中是第几首。

输出描述
输出一个数字代表小美能获得的最大愉悦值
*
*
* 小美最近买了一个小火车，小火车的每一节车厢都可以用一个小写字母表示。小美想知道，对于火车的某个前缀，其第k短的周期的长度是几。

定义周期为：对于一个长度为n的字符串，如果有一个长度为k的周期，当且仅当其满足对于所有1≤i≤n-k，都有si=si+k成立。



输入描述
第一行一个字符串，字符串只由小写英文字母组成，长度最多为105。

第二行一个数字q(1≤q≤105)，代表询问的组数。

接下来q行，每行两个空格隔开的数字u(1≤u≤n),k(1≤k≤105)代表询问的前缀长度和周期次序k。

输出描述
对于每组询问输出一行一个整数代表长度为 u 的前缀的第 k 短的周期长度。如果k大于该前缀所有的周期数量，则输出一行一个整数 -1。
*
* */