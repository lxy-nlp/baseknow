package Offer.Algorithm.Sort;


import Offer.DataStructure.ListNode;

// 自顶向下
    /*
    * 先用快慢指针找到中点
    * 再分 再合
    * */
public class MergeSort {
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head.next,slow = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode sorted = merge(left,right);
        return sorted;
    }


    public ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead,tmp1 = head1,tmp2 = head2;
        while(tmp1 != null && tmp2 != null)
        {
            if(tmp.val <= tmp2.val)
            {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            else{
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if(tmp1 != null)
            tmp.next = tmp1;
        else if(tmp2 != null)
            tmp.next = tmp2;
        return dummyHead.next;
    }

//自底向上
//        public ListNode sortListFromBottom(ListNode head)
//        {
//            if(head == null)
//                return head;
//            int length = 0;
//            ListNode node = head;
//            while(node != null)
//            {
//                length++;
//                node = node.next;
//            }
//            ListNode dummyHead = new ListNode(0,head);
//            for(int subLength = 1;subLength < length;subLength <<= 1)
//            {
//                ListNode prev = dummyHead,curr = dummyHead.next;
//                while(curr != null)
//                {
//                    ListNode head1 = curr;
//
//                }
//            }
//
//        }


    // 归并排序
    public static int[] aux;
    public static void sort(int[] a)
    {
        aux = new int[a.length];
        sort(a,0,a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi)
    {
        if(hi <= lo)
            return;
        int mid = (lo + hi) / 2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    public static void merge(int[] a,int lo, int mid, int hi)
    {
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++)
        {
            if(i > mid)                     a[k] = aux[j++];
            else if(j > hi)                 a[k] = aux[i++];
            else if(less(aux[j],aux[i]))    a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    public static boolean less(int a, int b)
    {
        return a < b;
    }


    // 逆序数组对
    class Solution {
        int[] nums, tmp;
        public int reversePairs(int[] nums) {
            this.nums = nums;
            tmp = new int[nums.length];
            return mergeSort(0, nums.length - 1);
        }
        private int mergeSort(int l, int r) {
            // 终止条件
            if (l >= r) return 0;
            // 递归划分
            int m = (l + r) / 2;
            int res = mergeSort(l, m) + mergeSort(m + 1, r);
            // 合并阶段
            int i = l, j = m + 1;
            for (int k = l; k <= r; k++)
                tmp[k] = nums[k];
            for (int k = l; k <= r; k++) {
                if (i == m + 1)
                    nums[k] = tmp[j++];
                else if (j == r + 1 || tmp[i] <= tmp[j])
                    nums[k] = tmp[i++];
                else {
                    nums[k] = tmp[j++];
                    res += m - i + 1; // 统计逆序对
                }
            }
            return res;
        }
    }

    public static ListNode mergeKList(ListNode[] lists)
    {
        if(lists == null || lists.length == 0)  return null;
        return merge(lists,0,lists.length - 1);
    }
    public static ListNode merge(ListNode[] lists, int left, int right)
    {
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists, mid + 1,right);
        return mergeTwoLists(l1,l2);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}

