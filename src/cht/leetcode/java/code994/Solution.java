package cht.leetcode.java.code994;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
 *
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 *
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为0、1或2
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/rotting-oranges">https://leetcode.cn/problems/rotting-oranges</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/5/13
 */

public class Solution {
    private static final int[][] AROUND = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int orangesRotting(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                }
            }
        }

        int result = 0;
        while (!deque.isEmpty()) {

            int size = deque.size();
            boolean hasInfect = false;
            for (int i = 0; i < size; i++) {
                int[] poll = deque.poll();
                int xTemp = poll[0];
                int yTemp = poll[1];



                for (int[] ints : AROUND) {
                    int xTarget = xTemp + ints[0];
                    int yTarget = yTemp + ints[1];
                    if (xTarget >= 0 && xTarget < x && yTarget >= 0 && yTarget < y  && grid[xTemp][yTemp] == 2) {
                        if (grid[xTarget][yTarget] == 1) {
                            grid[xTarget][yTarget] = 2;
                            deque.offer(new int[] {xTarget, yTarget});
                            hasInfect = true;
                        }
                    }
                }
            }
            if (hasInfect) {
                result++;
            }


        }

        for (int[] ints : grid) {
            for (int j = 0; j < y; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return result;
    }
}