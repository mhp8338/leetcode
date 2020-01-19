package knapsack01;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/10
 * @description: 0-1背包问题再优化
 * Space: O(1*C)
 * Time: O(n*C)
 * 由于只于上一行的前边数据有关，所以可以从后边开始状态转移
 * 转移后填充至后边，省下一行空间
 */
public class Solution4 {
    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        /*memo[i] 的最终值为背包容量为i时的最优解
         * 优化原理：从后往前，利用求得的解填充后边的槽位，得到最优解*/
        int[] memo = new int[c + 1];
        for (int i = 0; i <= c; i++) {
            memo[i] = i >= w[0] ? v[i] : 0;
        }

        /*
        i仍为待取得的物品
        j为背包容量
         */
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }
        return memo[c];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int c = 5;
        System.out.println(new Solution4().knapsack01(w, v, c));
    }
}
