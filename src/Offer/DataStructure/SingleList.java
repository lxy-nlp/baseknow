package Offer.DataStructure;


import Offer.DataStructure.ListNode;
import java.util.*;



class Node{
     int val;
     Node next;

    public Node(int val) { this.val = val; this.next = null;    }
    public Node(int val,Node next) { this.val = val;this.next = next;   }
}
public class SingleList {
    private Node head;

    public SingleList(Node head){
        this.head = head;
    }
    public SingleList()
    {

    }
    public void insertAtHead(Node newnode){
        if(head == null)
        {
            head = newnode;
            return;
        }

        newnode.next = head;
        head = newnode;
    }
    public void insertAtTail(Node newnode)
    {
        if(head == null)
        {
            head = newnode;
            return;
        }
        Node p = head;
        while(p.next != null)
        {
            p = p.next;
        }
        p.next = newnode;
    }
    public void insertAtTail(int val)
    {
        if(head == null)
        {
            head = new Node(val);
            return;
        }
        Node p = head;
        while(p.next != null)
        {
            p = p.next;
        }
        p.next = new Node(val);
    }
    public void deleteAtHead()
    {
        if(head == null)
            System.out.println("List is null can not delete");
        head = head.next;
    }
    public void deleteAtTail()
    {
        if(head == null)
            System.out.println("List is null can not delete");

        Node p = head;
        while(p.next.next != null)
        {
            p = p.next;
        }
        p.next = null;
    }

    // 链表的反转 有两种方法 一是 递归 二是迭代
    // 递归
    public Node reverseCur(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node last = reverseCur(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public Node reverse(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node p = head.next;
        Node q = head;
        q.next = null;
        while(p != null)
        {
            Node tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }
        return q;

    }

    // 第一个公共节点的定义,两个或多个链表的交汇节点
    // 找到第一个公共节点
    public Node FindFirstCommonNode_1(Node pHead1, Node pHead2) {
    //哈希表
        Set<Node> all = new HashSet<>();
        while(pHead1 != null)
        {
            all.add(pHead1);
            pHead1 = pHead1.next;

        }
        while(pHead2 != null)
        {
            if(all.contains(pHead2))
                return pHead2;
            all.add(pHead2);
            pHead2 = pHead2.next;
        }
        return null;
    }
    public Node FindFirstCommonNode(Node pHead1, Node pHead2) {
        int h1=0,h2=0;
        Node tmp1 = pHead1;
        Node tmp2 = pHead2;
        while(tmp1 != null)
        {
            h1++;
            tmp1 = tmp1.next;
        }
        while(tmp2 != null)
        {
            h2++;
            tmp2 = tmp2.next;
        }
        if(h1 > h2)
        {
            int delta = h1 - h2;
            while(delta > 0)
            {
                pHead1 = pHead1.next;
                delta--;
            }
            while(pHead1 != pHead2 && pHead1 !=null){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        else if(h1 < h2)
        {
            int delta = h1 - h2;
            while(delta > 0)
            {
                pHead1 = pHead1.next;
                delta--;
            }
            while(pHead1 != pHead2 && pHead1 !=null){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return pHead1;
    }
    // 查找第一个公共节点 哈希表版本
    // 将链表1全部加入哈希表 然后再遍历链表2看哈希表中是否包含该节点
    public Node FindFirstCommonNodeHashVersion(Node pHead1, Node pHead2)
    {
        HashSet<Node> note = new HashSet();
        while(pHead1 != null)
        {
            note.add(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null)
        {
            if(note.contains(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }

    // 查找倒数第K个元素
    public Node FindKthToTail (Node pHead, int k) {
        // write code here
        Stack<Node> nodestack = new Stack<Node>();

        while(pHead != null)
        {
            nodestack.push(pHead);
            pHead = pHead.next;
        }
        Node tmp = null;
        while(k > 0  && nodestack.isEmpty()== false && k <= nodestack.size())
        {
            tmp = nodestack.pop();
            k--;
        }
        return tmp;
    }

    //双指针的应用问题
    public Node removeNthFromEnd (Node head, int n) {
        // write code here
        if(head == null)
            return head;
        Node fast = head;
        Node slow = head;
        Node tmp = null;
        int i = 0;
        while(i < n)
        {
            fast = fast.next;
            i++;
        }
        if(fast == null)
            return head.next;
        while(fast != null)
        {
            fast = fast.next;
            tmp = slow;
            slow = slow.next;
        }
        tmp.next = slow.next;
        slow.next = null;
        return head;
    }

    public Node detectCycle(Node head) {
        if(head == null || head.next == null)
            return null;
        Node fast = head,slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
            {
                Node newfast = head;
                while(newfast != slow)
                {
                    newfast = newfast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public Node mergeTwoList(Node l1, Node l2)
    {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }

    // 每k个一组翻转链表
    // 栈
    public static ListNode reverseKgroupsStack(ListNode head,int k)
    {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(true)
        {
            int count = 0;
            ListNode tmp = head;
            while(tmp != null && count < k)
            {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if(count != k)
            {
                p.next = head;
                break;
            }
            while(!stack.isEmpty())
            {
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;

    }
    // 尾插法
    public static ListNode reverseKgroupsSelf(ListNode head,int k)
    {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = head;
        ListNode tmphead = new ListNode(0);
        ListNode tmp = tmphead;
        Stack<ListNode> stack = new Stack();
        while(dummy != null)
        {
            ListNode cur = dummy;
            dummy = dummy.next;
            cur.next = null;
            stack.push(cur);
            if(stack.size() == k)
            {
                while(!stack.isEmpty())
                {
                    tmp.next = stack.pop();
                    tmp = tmp.next;
                }
            }
        }


        while(!stack.isEmpty())
        {
            ListNode t = stack.pop();
            t.next = tmp.next;
            tmp.next = t;
        }
        return tmphead.next;
    }

    // 判断环形链表
    public static boolean isCircle(ListNode head)
    {
        ListNode slow = head, fast = head.next;
        while(fast != null)
        {
            if(slow == fast)
                return true;
            if(fast.next == null)
                return false;
            fast = fast.next.next;
            if(slow.next == null)
                return false;
            slow = slow.next;
        }
        return false;
    }


    // 合并两个有序链表
    public static Node mergeTwoLists (Node l1, Node l2) {
        // write code here
        Node head = new Node(0);
        Node tail = head;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null)
        {
            tail.next = l1;
        }

        if(l2 != null)
        {
            tail.next = l2;
        }
        return head.next;
    }

    //合并有序链表的递归版本
    public static Node mergeCur(Node l1,Node l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        System.out.println("l1.val : "+l1.val + " l2.val : " + l2.val);
        if(l1.val < l2.val)
        {
            l1.next = mergeCur(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next = mergeCur(l1,l2.next);
            return l2;
        }
    }

    // 环形链表入口

    // 大数相加

    // 链表的归并排序

    public static void main(String[] args) {
        SingleList l1 = new SingleList();
        l1.insertAtTail(1);
        l1.insertAtTail(3);
        l1.insertAtTail(5);
        l1.insertAtTail(4);
        l1.insertAtTail(6);
        Node h1 = new Node(2);
        h1.next = new Node(3);
        h1.next.next = new Node(4);
        h1.next.next.next = new Node(5);


        Node h2 = new Node(1);
        h2.next = new Node(3);
        h2.next.next = new Node(6);
        Node tt = mergeCur(h1,h2);
        System.out.print(tt.val);



//        ListNode tmp = reverseKgroupsSelf(h1,2);
//        System.out.print(tmp);
//        SingleList l2 = new SingleList();
//        l2.insertAtTail(1);
//        l2.insertAtTail(2);
//        SingleList l3 = new SingleList();
//        Node head = l3.mergeTwoList(l1.head,l2.head);
//        System.out.print(head);
//        Node rehead = l1.reverseCur(l1.head);
//        System.out.print(rehead);

    }
}
