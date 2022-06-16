package Offer.Algorithm.Sort;

public class QuickSort {
    public static void sort(Comparable[] a)
    {
        sort(a,0,a.length -1);
    }
    private static void sort(Comparable[] a,int low, int high)
    {
        if(high <= low) return;
        int j = partition(a,low,high);
        sort(a,low,j-1);
        sort(a,j+1,high);
    }
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
    private static int partition(Comparable[] a,int lo, int hi)
    {
        int i = lo, j= hi+1;
        Comparable v = a[lo];
        while(true)
        {
            while(less(a[++i],v))
            {
                if(i == hi)
                    break;
            }
            while(less(v,a[--j]))
            {
                if(j == lo)
                    break;
            }
            if(i >= j)
                break;
            exch(a,i,j);
        }
        exch(a,j,lo);
        return j;
    }
}
