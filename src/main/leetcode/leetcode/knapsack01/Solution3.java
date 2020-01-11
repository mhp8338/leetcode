package knapsack01;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/10
 * @description: 0-1背包问题的优化
 * Time: O(n*C)
 * Space: O(n*2)
 */
public class Solution3 {
    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        /*memo[0]存储偶数i的结果
         * memo[1]存储奇数i的结果
         * 优化原理：由于更新第i行的值只于第i-1有关*/
        int[][] memo = new int[2][c + 1];
        for (int i = 0; i <= c; i++) {
            memo[0][i] = i >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }
        return memo[(n - 1) % 2][c];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int c = 5;
        System.out.println(new Solution().knapsack01(w, v, c));
    }
}
