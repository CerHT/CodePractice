package cht.leetcode.java.code3;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters">https://leetcode-cn.com/problems/longest-substring-without-repeating-characters</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2019/9/9
 */
public class Solution {

    public static void main(String[] args) {
        //String s = "pwwkew";
        //String s = " ";
        //String s = "dvdf";
        String s = "bwf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> temp = new HashSet<>();

        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.length() && left <= right) {
            if (temp.add(s.charAt(right))) {
                right++;
            } else {
                temp.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> temp = new HashSet<>();

        int left = 0, right = 0;

        int result = 0;
        int max = 0;
        while (right < s.length()) {
            if (temp.add(s.charAt(right))) {
                right++;
                max++;
            } else {
                temp.clear();
                result = Math.max(result, max);
                max = 0;
                left++;
                right = left;
            }
        }
        return Math.max(result, max);
    }
}
