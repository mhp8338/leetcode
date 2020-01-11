package leetcode_198;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/10
 * @description: 递归+记忆化搜索
 */
public class Solution2 {
    private int[] memo;
    public int rob(int[] nums) {
        /*memo[i]表示[0,i]偷取的最大金钱*/
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return tryRob(nums.length-1,nums);
    }

    /**
     * @param index 尝试偷取[0,index]的房子
     * @param nums input
     * @return [0,index]的房子偷取的最多钱
     */
    private int tryRob(int index, int[] nums) {
        if(index < 0){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }

        int res=-1;
        /*状态转移方程*/
        for (int i = index; i >= 0; i--) {
            res = Math.max(res,nums[i]+tryRob(i-2,nums));
        }
        memo[index] = res;
        return res;
    }
}
