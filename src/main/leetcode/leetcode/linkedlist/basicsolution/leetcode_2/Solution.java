package linkedlist.basicsolution.leetcode_2;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/28
 * @description:
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        boolean isCarry = false;
        while(l1Cur != null && l2Cur != null){
            if(isCarry){
                l1Cur.val += 1;
                isCarry = false;
            }
            if((l1Cur.val + l2Cur.val) / 10  == 1){
                isCarry = true;
            }
            l1Cur.val = (l1Cur.val + l2Cur.val) % 10;
            cur.next = new ListNode(l1Cur.val);
            cur = cur.next;
            l1Cur = l1Cur.next;
            l2Cur = l2Cur.next;
        }

        if(l1Cur == null && l2Cur == null){
            if(isCarry){
                cur.next = new ListNode(1);
                return res.next;

            }
        }else if(l1Cur == null && l2Cur != null){
            cur.next = l2Cur;
        }else{
            cur.next = l1Cur;
        }
        cur = cur.next;
        if(!isCarry){
            return res.next;
        }

        while(cur != null){
            if(isCarry){
                cur.val += 1;
                isCarry = false;
            }
            if(cur.val / 10 == 1){
                isCarry = true;
                cur.val = 0;
            }
            cur = cur.next;
        }

        return res.next;

    }

    public static void main(String[] args) {
        new Solution().addTwoNumbers(new ListNode().createLinkedList(new int[]{1}),new ListNode().createLinkedList(new int[]{9,9})).printLinkedList();
    }
}
