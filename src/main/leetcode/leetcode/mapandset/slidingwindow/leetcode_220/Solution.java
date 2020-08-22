package mapandset.slidingwindow.leetcode_220;

import java.util.TreeSet;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/22
 * @description:
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicateOneSolution(int[] nums, int k, int t) {
        if (nums.length < 2) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove((long) nums[i - k - 1]);
            }
            if (set.floor((long) nums[i]) != null && (long) nums[i] - set.floor((long) nums[i]) <= t) {
                return true;
            }
            if (set.ceiling((long) nums[i]) != null && set.ceiling((long) nums[i]) - (long) nums[i] <= t) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.floor(nums[i]) != null && nums[i] <= set.floor(nums[i]) + t) {
                return true;
            }
            if (set.ceiling(nums[i]) != null && set.ceiling(nums[i]) <= nums[i] + t) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }
}
