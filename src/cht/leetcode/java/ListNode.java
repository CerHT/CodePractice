package cht.leetcode.java;

/**
 *
 *
 * @author chenhantao
 * @since 2022/4/24
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {this.val = val;}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
