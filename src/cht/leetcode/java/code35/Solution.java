package cht.leetcode.java.code35;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为 无重复元素 的 升序 排列数组
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/search-insert-position">https://leetcode-cn.com/problems/search-insert-position</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/4/21
 */
public class Solution {

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int temp = start + (end - start) / 2;
            if (nums[temp] == target) {
                return temp;
            }
            if (nums[temp] > target) {
                end = temp - 1;
            }
            if (nums[temp] < target) {
                start = temp + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5,6};
        System.out.println(searchInsert(a, 3));
    }
}
