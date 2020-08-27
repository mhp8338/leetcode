package linkedlist.basicsolution.leetcode_206;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/24
 * @description:
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // iteratively
    public ListNode reverseListIter(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // recursively
    public ListNode reverseListRecur(ListNode head) {

        return reverseListAdjcent(null, head);
    }

    private ListNode reverseListAdjcent(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverseListAdjcent(cur, next);
    }

    public ListNode reverseListRecurTwo(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = reverseListRecurTwo(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
}
