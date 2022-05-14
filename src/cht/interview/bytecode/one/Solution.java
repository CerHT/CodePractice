package cht.interview.bytecode.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 字节一面,最长重复子串,重复字段<=2
 *
 * @author chenhantao
 * @since 2022/5/9
 */
public class Solution {
    private static void solution1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Map<Character, Integer> map = new HashMap<>(16);
        int left = 0, right = 0;
        int result = 0;
        while (left <= right && right != s.length()) {
            char rightChar = s.charAt(right);

            Integer rightMap = map.get(rightChar);
            if (rightMap == null) {
                map.put(rightChar, 1);
            } else {
                map.put(rightChar, ++rightMap);
            }

            if (map.keySet().size() <= 2) {
                right++;
                result = Math.max(result, right - left);
            } else {
                char leftChar = s.charAt(left);
                Integer leftMap = map.get(leftChar);
                leftMap--;
                if (leftMap == 0) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, leftMap);
                }
                left++;
            }

        }
        System.out.println(result);
    }

    private static void solution2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int[] charRecord = new int[26];

        int charNum = 0;

        int left = 0, right = 0, result = 0;

        while (left <= right && right < s.length()) {
            char rightChar = s.charAt(right);

            if (charRecord[rightChar - 'a'] == 0) {
                charNum++;
                charRecord[rightChar - 'a'] = 1;
            } else {
                charRecord[rightChar - 'a']++;
            }

            if (charNum <= 2) {
                right++;
                result = Math.max(result, right - left);
            } else {
                char leftChar = s.charAt(left);
                charRecord[leftChar - 'a']--;
                if (charRecord[leftChar - 'a'] == 0) {
                    charNum--;
                }
                left++;
            }
        }
        System.out.println(result);
    }

}
