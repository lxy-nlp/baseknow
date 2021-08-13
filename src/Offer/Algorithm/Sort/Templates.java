package Offer.Algorithm.Sort;

public class Templates {
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
}
