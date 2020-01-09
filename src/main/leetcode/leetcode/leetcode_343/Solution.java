package leetcode_343;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/8
 * @description:
 */
class Solution {
    private int[] memo;
    public int integerBreak(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return breakInteger(n);
    }

    //将n进行分割，获得最大乘积
    private int breakInteger(int n){
        if(n==1){
            return 1;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        int res = -1;
        for(int i=1;i<=n-1;i++){
            //[i,n-i]
            //n-i
            res = maxThree(res,i*(n-i),i*breakInteger(n-i));
        }
        memo[n] = res;
        return res;
    }

    private int maxThree(int x,int y, int z){
        return Math.max(x,Math.max(y,z));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(2));
    }
}
