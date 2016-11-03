package cn.edu.bjtu.tencent;

/**
 * Created by pangchao on 2016/11/3.
 */
public class LinkedListRelevance {
    public static void main(String[] args) {

    }

    //递归法反转单链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    //迭代法反转单链表
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        p.next = null;
        while (q != null) {
            ListNode temp = q;
            q = q.next;
            temp.next = p;
            p = temp;
        }
        return p;
    }
}
