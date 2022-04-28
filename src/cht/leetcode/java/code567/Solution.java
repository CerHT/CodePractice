package cht.leetcode.java.code567;

import java.util.Arrays;

/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * 
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/permutation-in-string">https://leetcode-cn.com/problems/permutation-in-string</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/4/26
 */
public class Solution {

    public static void main(String[] args) {
        String a = "ab";
        String b = "eidbaooo";

        checkInclusion(a, b);
    }

    /**
     * todo
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] temp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i) - 'a']++;
            temp[s2.charAt(i) - 'a']++;
        }
         int diff = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                diff++;
            }
        }


        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        int[] temp = new int[26];
        int[] cache = new int[26];

        // 先行判断长度是否合规
        if (s1.length() > s2.length()) {
            return false;
        }

        // 缓存s1的字符数量,顺便对比第一轮
        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i) - 'a']++;
            cache[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(temp, cache)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            cache[s2.charAt(i) - 'a']++;
            cache[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(temp, cache)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        int[] template = new int[26];
        int[] cache = new int[26];

        // 缓存子串数量
        for (int i = 0; i < s1.length(); i++) {
            template[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = left + s1.length();

        while (right <= s2.length()) {
            for (int i = left; i < right; i++) {
                cache[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(template, cache)) {
                return true;
            } else {
                cache = new int[26];
                left++;
                right++;
            }
        }
        return Arrays.equals(template, cache);
    }
}
