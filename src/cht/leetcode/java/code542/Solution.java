package cht.leetcode.java.code542;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 * 
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0 
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/01-matrix">https://leetcode.cn/problems/01-matrix</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenhantao
 * @since 2022/5/12
 */
public class Solution {

    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ints = updateMatrix(a);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
    public static final int[][] AROUND = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int[][] updateMatrix(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;

        int[][] result = new int[x][y];
        boolean[][] seen = new boolean[x][y];

        Deque<int[]> deque = new LinkedList<>();
        // 所有0预先进队列
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (mat[i][j] == 0) {
                    deque.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }


        // bfs 对所有零进行广度优先
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int xTemp = poll[0];
            int yTemp = poll[1];
            for (int[] ints : AROUND) {
                int xTarget = xTemp + ints[0];
                int yTarget = yTemp + ints[1];

                if (xTarget >= 0 && xTarget < x && yTarget >= 0 && yTarget < y && !seen[xTarget][yTarget]) {
                    result[xTarget][yTarget] = result[xTemp][yTemp] + 1;
                    deque.offer(new int[]{xTarget, yTarget});
                    seen[xTarget][yTarget] = true;
                }
            }
        }

        return result;
    }
    
}
