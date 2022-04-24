package cht.leetcode.java.code189;

import java.util.Arrays;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释: 
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/rotate-array">https://leetcode-cn.com/problems/rotate-array</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/4/22
 */
public class Solution {

    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tempMark = (i + k) % nums.length;
            result[tempMark] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, result.length);
    }

    public static void rotate1(int[] nums, int k) {
        int count = 1;
        out:for (int i = 0; i < nums.length; i++) {
            int start = i;
            int value = nums[i];

            do  {
                int next = (start + k) % nums.length;
                int nextValue = nums[next];

                int temp = value;
                nums[i] = nextValue;
                nums[next] = temp;

                count++;

                start = next;
                value = nextValue;

                if (count == nums.length) {
                    break out;
                }
            } while (start != i);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        rotate1(a, 2);
        System.out.println(Arrays.toString(a));
    }
}
