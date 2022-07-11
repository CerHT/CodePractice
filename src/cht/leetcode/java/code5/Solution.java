package cht.leetcode.java.code5;

/**
 * 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-palindromic-substring">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/6/8
 */
public class Solution {

    public String longestPalindrome(String s) {
        int length = s.length();
        // 一个字符肯定是回文子串
        if (length < 2) {
            return s;
        }

        // 用来记录某个长度的子串是否是回文子串
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        int maxLength = 1, begin = 0;
        // 从长度为2的子串开始
        for (int strLen = 2; strLen < length; strLen++) {
            for (int left = 0; left < length; left++) {
                // 计算右界的坐标
                int right = strLen - 1 + left;

                // right 大于边界就break
                if (right >= length) {
                    break;
                }

                // 如果不相等,那肯定不是回文
                if (chars[left] != chars[right]) {
                    dp[left][right] = false;
                } else {
                    // 长度为2的肯定是回文
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        // 长度大于2的看它的子串是不是回文,例:cbabc, c和c相等,看bab是不是回文,因为是从短到长判断,因此可以判断出bab
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                // 如果是回文,并且长度大于最长,那就缓存和记录开始
                if (dp[left][right] && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    begin = left;
                }
            }

        }

        return s.substring(begin, begin + maxLength);
    }
}
