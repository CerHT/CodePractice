package cht.leetcode.code2;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x;}
 * }
 *
 * @author chenhantao
 * @since 2019/9/9
 */
public class Solution {
    /**
     * 参考了答案
     * 一开始思路很混乱，在判断节点为空和余数上不能做到平衡，
     * 小技巧是为null即值为0，以及每轮保存下来进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode temp = result;

        int remainder = 0;
        while (l1 != null || l2 != null || remainder != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + remainder;

            // 保留下来进位，加到下一次的加法中
            remainder = val / 10;

            // 这里是赋予next的值
            // 如果是赋予当前值的话，最后输出则尾部会多一个零，无法去除
            //temp.val = val % 10;
            //temp.next = new ListNode(0);
            temp.next = new ListNode(val % 10);
            temp = temp.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result.next;
    }
}
