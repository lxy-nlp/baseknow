package Exam;

public class GoodFuture {


    // 逆波兰式

    // 两数目标和

    // 大数相乘
    public String multiply (String num1, String num2) {
        // write code here
        if(num1 == "0" && num2 == "0")
            return "0";
        int m = num1.length(),n = num2.length();
        int[] a = new int[m+n];
        for(int i = m - 1; i >=0; i--)
        {
            int n1 = num1.charAt(i)-'0';
            for(int j = n-1;j >=0; j--)
            {
                int n2 = num2.charAt(j) - '0';
                int sum = (a[i+j+1] + n1 * n2);
                a[i+j+1] = sum % 10;
                a[i+j] = sum / 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < a.length;i++)
        {
            if(i == 0 && a[i] == 0) continue;
            res.append(a[i]);
        }
        return res.toString();
    }
}
