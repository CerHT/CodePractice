package cht.leetcode.java.code977;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/squares-of-a-sorted-array">https://leetcode-cn.com/problems/squares-of-a-sorted-array</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/4/21
 */
public class Solution {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = num * num;
            result[i] = temp;

        }
        Arrays.sort(result);
        return result;
    }
}
