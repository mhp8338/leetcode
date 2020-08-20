package mapandset.slidingwindow.leetcode_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/20
 * @description:
 */
public class Solution {
    /**
     *
     * 解题思路: 利用一个MAP存储数据，如果满足要求则返回TRUE
     *
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public boolean containsNearbyDuplicateFirstSolution(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        //<nums[i],index>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     *
     * 解题思路: 滑动窗口+set集合
     *
     * time complexity: O(n)
     * space complexity: O(k)
     */
    public boolean containsNearbyDuplicateSecondSolution(int[] nums, int k) {
        if(nums.length<2){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            //制造一个滑动窗口，使得set仅存储[i,i+k]的数值
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
