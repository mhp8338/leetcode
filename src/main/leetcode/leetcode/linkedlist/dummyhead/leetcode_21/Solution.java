package linkedlist.dummyhead.leetcode_21;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/9/1
 * @description:
 */
public class Solution {
    /**
     *
     * 解题思路: 递归法
     *
     *
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoListsRecursive(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoListsRecursive(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsIteration(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(c1!=null && c2!=null){
            if(c1.val >= c2.val){
                cur.next = c2;
                c2 = c2.next;
            }else{
                cur.next = c1;
                c1 = c1.next;
            }
            cur = cur.next;

        }

        while(c1 != null){
            cur.next = c1;
            c1 = c1.next;
            cur = cur.next;
        }

        while(c2 != null){
            cur.next = c2;
            c2 = c2.next;
            cur = cur.next;
        }
        return res.next;

    }


}
