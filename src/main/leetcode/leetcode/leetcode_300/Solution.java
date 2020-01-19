package leetcode_300;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/12
 * @description: 300.Longest Increasing Subsequence
 * solve method: Recurse
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int res = 1;
        for(int i=0;i<n;i++){
            res = Math.max(res,findMaxLength(nums,i));
        }
        return res;
    }

    /**
     * 找到以nums[index]为结尾的最长递增子序列的长度
     * @param nums 输入数组
     * @param index nums[index]
     * @return 以nums[index]为结尾的最长递增子序列
     */
    private int findMaxLength(int[] nums, int index){
        if(index == 0){
            return 1;
        }
        /*
        状态转移矩阵:max(findLengthOfLIS(nums[],j)+1 nums{j<index})
        */
        int result = 1;
        for (int j=0;j<index;j++){
            if(nums[j]<nums[index]){
                result = Math.max(findMaxLength(nums,j)+1,result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
