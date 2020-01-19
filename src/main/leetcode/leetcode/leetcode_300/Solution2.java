package leetcode_300;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/12
 * @description: 动态规划
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[n];
        /*所有数字初始化为1，由于每个数字都算长度为1*/
        Arrays.fill(memo,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    memo[i] = Math.max(memo[i],memo[j]+1);
                }
            }
        }
        int res = 1;
        for(int m:memo){
            res = Math.max(res,m);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution2().lengthOfLIS(nums));
    }
}
