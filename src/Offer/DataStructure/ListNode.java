package Offer.DataStructure;

public class ListNode {
    public ListNode next;
    public  int val;
    public ListNode() { }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
