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
     }

