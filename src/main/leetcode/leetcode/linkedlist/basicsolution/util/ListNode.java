package linkedlist.basicsolution.util;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/27
 * @description:
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;

        }
        return this;
    }

    public void printLinkedList() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new ListNode().createLinkedList(new int[]{0, 1, 2}).printLinkedList();
    }


}
