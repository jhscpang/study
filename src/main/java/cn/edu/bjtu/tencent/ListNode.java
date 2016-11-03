package cn.edu.bjtu.tencent;

/**
 * Created by pangchao on 2016/11/3.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 1->2->3->4->5
    public static ListNode generateLinkedList() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        return one;
    }

    public static void printLinkedList(ListNode root) {
        while (root != null) {
            System.out.print(root.val);
            if (root.next != null) {
                System.out.print("->");
            }
            root = root.next;
        }
    }

    public static void main(String[] args) {
        ListNode root = ListNode.generateLinkedList();
        ListNode.printLinkedList(root);
    }
}
