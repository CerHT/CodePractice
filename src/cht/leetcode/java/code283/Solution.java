package cht.leetcode.java.code283;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/move-zeroes">https://leetcode-cn.com/problems/move-zeroes</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/4/22
 */
public class Solution {

    public static void main(String[] args) {
        //int[] a = {0, 1, 0, 3, 12};
        int[] a = {4,2,4,0,0,3,0,5,1,0};
        //int[] a = {0,1,0,3,12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    public static void moveZeroes(int[] nums) {
        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
            }
        }
    }
}
