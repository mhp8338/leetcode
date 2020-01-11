package leetcode_198;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/10
 * @description: 递归
 */
public class Solution1 {
    public int rob(int[] nums) {
        return tryRob(0,nums);
    }

    /**
     * @param index 尝试偷取[index,nums.size()-1]的房子
     * @param nums house
     * @return rob money
     */
    private int tryRob(int index, int[] nums){
        if(index >= nums.length){
            return 0;
        }

        int res = -1;
        for(int i=index;i<= nums.length-1;i++){
            res = Math.max(res,nums[i]+tryRob(i+2,nums));
        }
        return res;
    }
}
