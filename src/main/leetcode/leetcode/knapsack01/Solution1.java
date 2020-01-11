package knapsack01;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/10
 * @description: 0-1背包问题(递归+记忆搜索)
 */
public class Solution1 {

    /**
     * memo[i]为[0,i]得到的最优解
     */
    private int[][] memo;

    /**
     * @param w 重量
     * @param v 价值
     * @param C 背包容量
     * @return 最大的价值
     */
    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],-1);
        }
        return getMaxValue(w, v, C, n - 1);
    }

    /**
     * @param w 重量
     * @param v 价值
     * @param c 背包容量
     * @param index [0,index]得到的最大价值
     * @return 最大价值
     */
    private int getMaxValue(int[] w, int[] v, int c, int index) {
        if (index<0||c<=0){
            return 0;
        }
        if(memo[index][c] != -1){
            return memo[index][c];
        }

        int res = getMaxValue(w,v,c,index-1);
        if(c>=w[index]){
            res = Math.max(res,v[index]+getMaxValue(w,v,c-w[index],index-1));
        }
        memo[index][c] = res;
        return res;
    }
    public static void main(String[] args) {
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        int c = 5;
        System.out.println(new Solution().knapsack01(w,v,c));
    }
}
