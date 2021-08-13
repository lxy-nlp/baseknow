package Offer.Algorithm.Sort;

public class ChooseAndInsertAndBubble {
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a,int i,int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void chooseSort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 0; i < N; i++)
        {
            int min = i;
            for(int j = i+1; j < N;j++)
                if(less(a[j],a[min]))
                    min = j;
            exch(a,i,min);
        }
    }

    public static void inserSort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 1; i < N; i++)
        {
            for(int j = i; j > 0 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
        }
    }

    public static void bubbleSort(Comparable[] a)
    {
        int N = a.length;
        boolean flag = false;// 检测是否有序
        for(int i = 0; i < N-1; i++)
        {
            for(int j = 0; j < N-1-i; j++)
            {
                if(less(a[j],a[j+1]))
                {
                    exch(a,i,j);
                    flag = true;
                }
            }
            if(!flag)
                return;
        }
    }

}
