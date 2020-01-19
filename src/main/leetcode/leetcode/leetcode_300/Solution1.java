package leetcode_300;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/12
 * @description: 记忆搜索法+递归
 */
public class Solution1 {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = 1;
        memo = new int[n];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n; i++) {
            res = Math.max(res, findMaxLength(nums, i));
        }
        return res;
    }

    private int findMaxLength(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }

        if (memo[index] != -1) {
            return memo[index];
        }
        int res = 1;
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                res = Math.max(findMaxLength(nums, i) + 1, res);
            }
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution1().lengthOfLIS(nums));
    }
}
