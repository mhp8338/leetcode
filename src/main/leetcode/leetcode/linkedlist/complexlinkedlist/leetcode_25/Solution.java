package linkedlist.complexlinkedlist.leetcode_25;

import linkedlist.basicsolution.util.ListNode;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/9/2
 * @description:
 */
public class Solution {
    /**
     *
     * 解题思路: 找到要反转的子链，反转后，再将前后端连接
     *
     * time complexity: O()
     * space complexity: O()
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode right = head;
        ListNode left;
        int aim = k;
        while(right != null){
            while(right != null && right.next != null && aim>1){
                right = right.next;
                aim--;
            }

            if(aim > 1){
                break;
            }

            //pre -> [left,right] reverse
            left = pre.next;
            ListNode rightTemp = right.next;
            ListNode curl = left;
            ListNode curr = left.next;
            while(curl != right){
                ListNode temp = curr.next;
                curr.next = curl;
                curl = curr;
                curr = temp;
            }
            pre.next = right;
            left.next = rightTemp;
            pre = left;
            aim = k;
            right = pre.next;


        }

        return dummyHead.next;

    }

    /**
     *
     * 解题思路:
     *
     * time complexity: O()
     * space complexity: O()
     */
    public ListNode reverseKGroupSecondMethod(ListNode head, int k) {
        int count = 1;
        ListNode cur = head;
        while(count<=k && cur!=null){
            cur = cur.next;
            count ++;
        }

        if(count == k + 1){
            ListNode newHead = this.reverseLinkedList(head,k);
            head.next = this.reverseKGroup(cur,k);
            return newHead;
        }
        return head;

    }

    /**
     *
     * 解题思路:
     *
     * time complexity: O()
     * space complexity: O()
     */
    private ListNode reverseLinkedList(ListNode head,int k){
        ListNode p = head;
        ListNode nextNode = head.next;
        while(k>1){
            ListNode temp = nextNode.next;
            nextNode.next = p;
            p = nextNode;
            nextNode = temp;
            k--;
        }
        head.next = null;
        return p;
    }

    public ListNode reverseKGroupThirdMethod(ListNode head, int k) {
        int count = 1;
        ListNode cur = head;
        while(count<=k && cur!=null){
            cur = cur.next;
            count ++;
        }

        if(count == k + 1){
            ListNode newHead = this.reverse(head,cur);
            head.next = this.reverseKGroupThirdMethod(cur,k);
            return newHead;
        }
        return head;

    }

    private ListNode reverse(ListNode head,ListNode successor){
        if(head.next == successor){
            return head;
        }
        ListNode newHead = reverse(head.next,successor);
        head.next.next = head;
        head.next = null;
        return newHead;
    }



    public static void main(String[] args) {
        new Solution().reverseKGroupSecondMethod(new ListNode().createLinkedList(new int[]{1,2,3,4,5}),2);
    }
}
