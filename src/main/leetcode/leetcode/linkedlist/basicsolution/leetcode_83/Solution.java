package linkedlist.basicsolution.leetcode_83;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/27
 * @description:
 */
public class Solution {
    /**
     * 解题思路: 迭代法
     * <p>
     * <p>
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public ListNode deleteDuplicatesIteration(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        /*
         * cur != null : 由于cur指针可能移动到NULL cur.next 就会产生问题
         * */
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                /*[1,1,1] : 一直到不相等的时候才移动指针*/
                cur = cur.next;
            }
        }
        return head;
    }
    /**
     *
     * 解题思路: 递归方法
     *
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3};
        new Solution().deleteDuplicatesIteration(new ListNode().createLinkedList(a)).printLinkedList();

    }
}
