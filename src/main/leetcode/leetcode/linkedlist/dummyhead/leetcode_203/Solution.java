package linkedlist.dummyhead.leetcode_203;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/31
 * @description:
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        /*两种情况，指针到null，指针到最后一个非NULL数字*/
        while(cur != null && cur.next != null){
            if(cur.next.val == val){
                /*一直到不等于这个数字的值*/
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
