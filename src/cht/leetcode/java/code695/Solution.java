package cht.leetcode.java.code695;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,
 * 0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,
 * 0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 *
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/max-area-of-island">https://leetcode-cn.com/problems/max-area-of-island</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/4/29
 */
public class Solution {
    private static int count = 0;

    public static void main(String[] args) {
        int[][] a = new int[][] {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int i = maxAreaOfIsland(a);
        System.out.println(i);
    }

    public static int[][] around = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(grid, i, j);
                result = Math.max(result, count);
                count = 0;
            }
        }
        return result;
    }

    public static void dfs(int[][] temp, int x, int y) {
        if (x < 0 || x >= temp.length || y < 0 || y >= temp[0].length) {
            return;
        }

        if (temp[x][y] == 0) {
            return;
        }

        temp[x][y] = 0;
        count++;

        for (int[] ints : around) {
            int xOffset = ints[0];
            int yOffset = ints[1];
            dfs(temp, x + xOffset, y + yOffset);
        }
        //return sum;
    }

    public static int maxAreaOfIsland1(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int count = 0;

                Deque<Integer> dequeI = new ArrayDeque<>();
                Deque<Integer> dequeJ = new ArrayDeque<>();

                dequeI.push(i);
                dequeJ.push(j);

                while (!dequeI.isEmpty()) {
                    int curI = dequeI.pop();
                    int curJ = dequeJ.pop();

                    if (curI < 0 || curI >= grid.length || curJ < 0 || curJ >= grid[0].length) {
                        continue;
                    }
                    if (grid[curI][curJ] == 0) {
                        continue;
                    }

                    grid[curI][curJ] = 0;
                    count++;

                    for (int[] ints : around) {
                        int iOffset = ints[0];
                        int jOffset = ints[1];

                        dequeI.push(curI + iOffset);
                        dequeJ.push(curJ + jOffset);
                    }
                }
                result = Math.max(count, result);
            }
        }
        return result;
    }
}