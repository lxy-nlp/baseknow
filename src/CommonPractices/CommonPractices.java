package CommonPractices;

import Offer.DataStructure.ListNode;

public class CommonPractices {
    //
    public static void main(String[] args)
    {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        LinkedListSort ls = new LinkedListSort();
        ListNode res = ls.sortList(head);
        System.out.println(res);

    }

}
class LinkedListSort
{
    public ListNode sortList(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        return sort(head,null);
    }
    public ListNode sort(ListNode head, ListNode tail)
    {
        if(head == null)
            return null;
        if(head.next == tail) // 不可分的情况  只有两个节点的情况下其实就不可分了
        {
            System.out.println("head:" +head.val);
            if(tail != null)
                System.out.println("tail: "+tail.val);
            else
                System.out.println("tail: "+tail);

            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while(fast != tail && fast.next != tail)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode left = sort(head,mid);
        ListNode right = sort(mid,tail);
        return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right)
    {
        ListNode dummyNode = new ListNode();
        ListNode helper = dummyNode;
        while(left != null && right != null)
        {
            if(left.val < right.val)
            {
                helper.next = left;
                left = left.next;
            }
            else
            {
                helper.next = right;
                right = right.next;
            }
            helper = helper.next;
        }
        helper.next = left == null ? right : left;
        return dummyNode.next;
    }
}