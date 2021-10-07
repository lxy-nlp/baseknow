package Offer;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BaseApi {

    public static void main(String[] args)
    {
//        List<Integer> tt = Arrays.asList(1,2,3);
//        System.out.print(tt);
//        LinkedList<String> ss = new LinkedList<>();
//        ss.add("1");
//        ss.add("2");
//        String[] as = ss.toArray(new String[ss.size()]);
//        System.out.println(as);
        printOut();

    }

    public static void StringBuilderAPI(){
        StringBuilder sb = new StringBuilder();
        sb.append('c');
        sb.reverse();  // 翻转
        sb.toString(); // 转成String
        sb.capacity(); // 求容量
    }
    public static void ArrayApi()
    {
        // 即返回值小于零，则不交换o1和o2的位置；返回值大于零，则交换o1和o2的位置
        int[][] intervals = new int[5][];
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        LinkedList<Integer> note = new LinkedList();
        Collections.sort(note,(o1,o2)->o1 - o2);
        List<Integer> tt = Arrays.asList(1,2,3); // 由数组创建List
    }

    public static void printOut()
    {
        System.out.printf("%.2f\n",3.145926);
        System.out.println(String.format("%.2f",3.14567));

    }
}

