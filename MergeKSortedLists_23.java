package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int  n = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            queue.offer(node);
        }
        ListNode res = new ListNode(0);
        ListNode pre = res;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pre.next = node;
            pre = node;
            if (node.next != null) queue.offer(node.next);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
