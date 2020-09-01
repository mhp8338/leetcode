package linkedlist.complexlinkedlist.leetcode_24;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/9/1
 * @description:
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        ListNode left = head;
        ListNode right = head.next;
        ListNode temp;
        while(left != null && right != null){
            temp = right.next;
            right.next = left;
            left.next = temp;
            pre.next = right;

            pre = left;
            left = left.next;
            if(left == null){
                break;
            }
            right = left.next;
        }
        if(left != null){
            pre.next = left;
        }
        return dummyHead.next;
    }

    public ListNode swapPairsSecondMethod(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        ListNode cur = head;
        ListNode temp;
        while(cur!=null && cur.next != null){
            temp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = temp;

            pre = cur;
            cur = cur.next;


        }
        if(cur != null){
            pre.next = cur;
        }
        return dummyHead.next;
    }
}
