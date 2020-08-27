package linkedlist.basicsolution.leetcode_92;

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

    //[3,5] 1,2
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        // 防止空指针异常
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = head;
        ListNode pre = dummyHead;
        int i = 1;
        while (i < m) {
            pre = cur;
            cur = cur.next;
            i++;
        }
        ListNode leftNode = pre;
        pre = cur;
        cur = cur.next;
        i += 1;
        while (cur != null && i < n + 1) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }
        leftNode.next.next = cur;
        leftNode.next = pre;
        return dummyHead.next;
    }

    /**
     *
     * 解题思路:
     * （1）利用虚拟头指针
     * （2）利用双指针调换位置
     *
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public ListNode reverseBetweenSecondSolution(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode left = pre.next;
        ListNode right = left.next;
        for(int i=0;i<n-m;i++){
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        pre.next.next = right;
        pre.next = left;
        return dummyHead.next;

    }
}
