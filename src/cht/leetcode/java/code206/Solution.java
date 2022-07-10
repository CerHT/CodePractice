package cht.leetcode.java.code206;

import cht.leetcode.java.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 *
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reverse-linked-list">https://leetcode.cn/problems/reverse-linked-list</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/5/17
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode next = node.next;
        System.out.println("next = " + next.val);

        node.next = node;
        System.out.println("node = " + node.val + " and node.next = " + node.next.val);

        node = next;
        System.out.println("node = " + node.val + " and node.next = ");
        System.out.println("next = " + next.val + " and next.next = " + next.next.val);

    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            // 缓存当前值的下一个
            ListNode next = current.next;

            // 下一个指向之前
            current.next = pre;
            // 之前换成现在
            pre = current;
            // 现在换成下一个
            current = next;


        }

        return pre;
    }
}
