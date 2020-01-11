package knapsack01;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/10
 * @description: 0-1背包问题(动态归化)
 * Space:O(n*C)
 * Time:O(n*C)
 */
public class Solution2 {
    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        if(n == 0){
            return 0;
        }
        /*
        memo[i][j]存储的是状态最优解
        i:考虑[0,i]个物品，且容量不大于j，最大价值
        */
        int[][] memo = new int[n][c+1];

        /*状态初始化*/
        for(int i=0;i<=c;i++){
            memo[0][i] = i>=w[0]?v[0]:0;
        }

        for(int j=1;j<n;j++){
            for(int k=0;k<=c;k++){
                /*不放入第j个物品*/
                memo[j][k] = memo[j-1][k];
                if(k>=w[j]){
                    /*
                    放第j个物品
                    memo[j-1][k-w[j]]回退至能放入j物品的最佳状态
                    */
                    memo[j][k] = Math.max(memo[j][k],v[j]+memo[j-1][k-w[j]]);
                }
            }
        }
        return memo[n-1][c];
    }

    public static void main(String[] args) {
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        int c = 5;
        System.out.println(new Solution().knapsack01(w,v,c));
    }
}
