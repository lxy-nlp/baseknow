//package Exam;
//import java.util.Scanner;
//public class Honor {
//
//    // 报文转义
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        int length = Integer.parseInt(sc.next(),16);
//        int len = length;
//        for(int i = 1; i < length; i++)
//        {
//            String temp = sc.next();
//            if(temp.equals("A"))
//            {
//                sb.append("12 34");
//                len++;
//            }
//            else if(temp.equals("B"))
//            {
//                sb.append("AB CD");
//                len++;
//            }
//            else{
//                sb.append(temp).append(" ");
//            }
//        }
//        System.out.println(Integer.toHexString(len).toUpperCase() + " " +sb.toString().trim());
//        sc.close();
//    }
//
////     ip地址转10进制
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        String ip = sc.nextLine();
//        Long res = ipToInt(ip);
//        System.out.println(res);
//    }
//    public static long ipToInt(String ip)
//    {
//        String[] items = ip.split("\\.");
//        return Long.valueOf(items[0]) << 24 | Long.valueOf(items[1]) << 16 | Long.valueOf(items[2]) << 8 | Long.valueOf(items[3]);
//
//    }
//
//
//    // 最相邻的素数对
//
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int a  = 0, b = 0;
//        if(isPrime(n))
//            System.out.println(0);
//        else{
//            int minDis = n;
//            for(int i = 1; i <= n/2;i++)
//            {
//                if(isPrime(i) && isPrime(n-i))
//                {
//                    if(n - 2 * i < minDis)
//                    {
//                        a = i;
//                        b = n-i;
//                        minDis = b-a;
//                    }
//                }
//            }
//            System.out.println(minDis);
//        }
//    }
//    public static boolean isPrime(int num)
//    {
//        for(int i = 2; i < num; i++)
//        {
//            if(num % i == 0)
//            {
//                return false;
//            }
//        }
//        return true;
//    }
//}
//
//
