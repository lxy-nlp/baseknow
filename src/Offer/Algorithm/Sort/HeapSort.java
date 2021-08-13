package Offer.Algorithm.Sort;

public class HeapSort {
    public void heapify(int[] tree,int n,int i)
    {
        if(i >= n)
            return;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if(c1 < n && tree[c1] > tree[max])
        {
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max])
        {
            max = c2;
        }
        if(max != i)
        {
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    public void buildHeap(int[] tree,int n)
    {
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        int i = 0;
        for(i = parent; i >= 0; i--)
        {
            heapify(tree,n,i);
        }
    }

    public void heapSort(int[] tree,int n)
    {
        buildHeap(tree,n);
        for(int i = n-1; i >= 0;i--)
        {
            swap(tree,i,0);
            heapify(tree,i,0);
        }
    }

    public void swap(int[] tree,int i, int j)
    {
        int tmp = tree[i];
        tree[i] = tree[j];
        tree[j] = tmp;
    }

}
