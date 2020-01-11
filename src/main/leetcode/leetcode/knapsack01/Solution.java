package knapsack01;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/10
 * @description: 0-1背包问题 (递归解法)
 */
public class Solution {
    /**
     * @param w 重量
     * @param v 价值
     * @param C 背包容量
     * @return 最大的价值
     */
    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        return getMaxValue(w, v, C, n - 1);
    }

    /**
     * @param w     重量
     * @param v     价值
     * @param c     背包容量
     * @param index [0,index]得到的最大价值
     * @return 最大价值
     */
    private int getMaxValue(int[] w, int[] v, int c, int index) {
        /*递归中止条件*/
        if (index < 0 || c <= 0) {
            return 0;
        }
        /*添加第index个物品*/
        int res = getMaxValue(w, v, c, index - 1);
        /*不添加第index物品*/
        if (c >= w[index]) {
            res = Math.max(res, v[index] + getMaxValue(w, v, c - w[index], index - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        int c = 5;
        System.out.println(new Solution().knapsack01(w,v,c));
    }
}
