package leetcode_198;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/9
 * @description:
 */
class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if(size == 0){
            return 0;
        }
        /*
        //memo[i] 考虑偷取[0,i]

        int[] memo = new int[size];
        memo[0] = nums[0];
        for(int i=1;i<=size-1;i++){
            for(int j=i;j>=0;j--){
                memo[i] = Math.max(memo[i],nums[j]+(j-2<0?0:memo[j-2]));
            }
        }
        return memo[size-1];
         */

        int[] memo = new int[size];
        //memo[i]考虑偷取[i,size-1]
        memo[size-1] = nums[size-1];
        for (int i=size-2;i>=0;i--){
            for (int j = i; j < size; j++) {
                memo[i] = Math.max(memo[i],nums[j]+(j+2<size?memo[j+2]:0));
            }
        }
        return memo[0];


    }
}
