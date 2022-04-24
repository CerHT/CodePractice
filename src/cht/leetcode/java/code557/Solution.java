package cht.leetcode.java.code557;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii">https://leetcode-cn.com/problems/reverse-words-in-a-string-iii</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/4/24
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0, right = 0;

        while (right <= s.length()) {
            if (right == s.length() || s.charAt(right) == ' ') {
                char[] temp = new char[right - left];
                for (int i = 0; i < right - left; i++) {
                    temp[i] = s.charAt(left + i);
                }
                reverseString(temp);
                stringBuilder.append(temp).append(" ");
                left = right + 1;
            }
            right++;
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
