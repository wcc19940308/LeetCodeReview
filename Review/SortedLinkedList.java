package LeetCode.Review;

/**
 * 单链表奇数位递增，偶数位递减，使用O（1）的空间使得链表递增
 * 1.将链表拆分 2.将偶数位的链表反转 3.合并2个单链表
 */
public class SortedLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode sortedLinkedList(ListNode head) {
        ListNode[] listNodes = divided(head);
        ListNode reverse = reverse(listNodes[1]);
        ListNode res = sort(listNodes[0], reverse);
        return res;
    }

    public static ListNode[] divided(ListNode head) {
        ListNode p1 = head, p2 = head.next;
        ListNode res1 = head, res2 = head.next;
        while (p2 != null && p2.next != null) {
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        return new ListNode[]{res1, res2};
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode sort(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val < head2.val ? head1 : head2;
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = cur1 == head1 ? head2 : head1;
        ListNode pre = null, next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
            pre.next = cur1 == null ? cur2 : cur1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        ListNode res = sortedLinkedList(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
