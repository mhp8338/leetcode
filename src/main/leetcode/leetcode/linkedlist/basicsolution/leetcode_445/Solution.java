package linkedlist.basicsolution.leetcode_445;

import linkedlist.basicsolution.util.ListNode;

import java.util.Stack;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/31
 * @description:
 */
public class Solution {
    /**
     *
     * 解题思路:
     * 三个stack,两个存储L1,L2,相当于变换l1,l2方向
     * 剩下一个stack用于反转
     *
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public ListNode addTwoNumbersFirstMethod(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        ListNode res = new ListNode(0);
        ListNode c1 = l1;
        ListNode c2 = l2;
        while(c1 != null){
            st1.push(c1.val);
            c1 = c1.next;
        }
        while(c2 != null){
            st2.push(c2.val);
            c2 = c2.next;
        }
        int carry = 0;
        int aim;
        while(!st1.empty() || !st2.empty()){
            int n1 = 0;
            int n2 = 0;
            if(!st1.empty()){
                n1 = st1.pop();
            }
            if(!st2.empty()){
                n2 = st2.pop();
            }
            aim = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            temp.push(aim);
        }
        if(carry != 0){
            temp.push(carry);
        }

        ListNode cur = res;
        while(!temp.empty()){
            cur.next = new ListNode(temp.pop());
            cur = cur.next;
        }
        return res.next;
    }

    /**
     *
     * 解题思路: 反向添加节点
     *
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public ListNode addTwoNumbersSecondMethod(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode pre = null;
        ListNode c1 = l1;
        ListNode c2 = l2;
        while(c1 != null){
            st1.push(c1.val);
            c1 = c1.next;
        }
        while(c2 != null){
            st2.push(c2.val);
            c2 = c2.next;
        }
        int carry = 0;
        int aim;
        while(!st1.empty() || !st2.empty()){
            int n1 = 0;
            int n2 = 0;
            if(!st1.empty()){
                n1 = st1.pop();
            }
            if(!st2.empty()){
                n2 = st2.pop();
            }
            aim = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            /*反向添加节点 pre*/
            ListNode node = new ListNode(aim);
            node.next = pre;
            pre = node;

        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = pre;
            pre = node;
        }
        return pre;
    }
}
