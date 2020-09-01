package linkedlist.dummyhead.leetcode_82;

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
     * 解题思路:
     * （1）利用辅助指针找到当前指针应该跳转的位置
     * （2）虚拟头节点（因为需要从第一个元素算起）
     *
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode probe;
        while(cur != null && cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                //遇见重复
                probe = cur.next;
                //找到最后一个重复的数字
                while(probe!= null && probe.next!=null && probe.next.val == probe.val){
                    probe = probe.next;
                }
                cur.next = probe.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyHead.next;

    }
}
