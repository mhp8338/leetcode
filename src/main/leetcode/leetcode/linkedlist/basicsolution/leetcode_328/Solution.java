package linkedlist.basicsolution.leetcode_328;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/28
 * @description:
 */
public class Solution {
    /**
     *
     * 解题思路: 复制两个链表，然后合并
     *
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public ListNode oddEvenListFirstSolution(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int i = 1;

        ListNode odd = new ListNode(0);
        ListNode oddCur = odd;
        ListNode even = new ListNode(0);
        ListNode evenCur = even;
        while(head != null){
            if(i % 2 == 1){
                oddCur.next = head;
                oddCur = oddCur.next;
            }else{
                evenCur.next = head;
                evenCur = evenCur.next;
            }
            head = head.next;
            i++;
        }
        oddCur.next = even.next;
        evenCur.next = null;
        return odd.next;
    }

    /**
     *
     * 解题思路: 双指针，先奇指针走后偶指针走
     *
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public ListNode oddEvenListSecondSolution(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        final ListNode fEven = head.next;
        ListNode even = fEven;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = fEven;
        return head;

    }
}
