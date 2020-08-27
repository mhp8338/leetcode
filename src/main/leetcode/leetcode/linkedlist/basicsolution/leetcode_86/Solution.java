package linkedlist.basicsolution.leetcode_86;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/27
 * @description:
 */
public class Solution {
    /**
     *
     * 解题思路:
     * （1）双指针big or small
     * （2）另建一个linklist存储big，找完small与big相连接
     *
     * time complexity: O()
     * space complexity: O()
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode small = dummyHead;
        ListNode big = new ListNode(0);
        ListNode bigPoint = big;
        while(small != null && small.next!=null){
            if(small.next.val >= x){
                /*必须新建一个，否则会带有不合格的small*/
                bigPoint.next = new ListNode(small.next.val);
                bigPoint = bigPoint.next;

                small.next = small.next.next;
            }else{
                small = small.next;
            }
        }
        small.next = big.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition(new ListNode().createLinkedList(new int[]{1,4,3,2,5,2}),3));
    }
}
