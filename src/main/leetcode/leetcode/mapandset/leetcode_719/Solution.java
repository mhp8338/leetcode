package mapandset.leetcode_719;

import java.util.*;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/19
 * @description:
 */
public class Solution {

    /**
     * （1）K-smallest => 列出所有情况，利用优先队列解决
     * （2）第K小的，需要每次吐出最大值的优先队列，维持队列的尺寸为K
     * （3）第K大的用最小优先队列,每次吐出最小的值
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePairFirstSolution(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer l1, Integer l2) {
                return l2 - l1;
            }

        });
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            list.add(Math.abs(nums[i] - nums[i - 1]));
        }
        for (int in : list) {
            pq.add(in);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek() == null ? 0 : pq.peek();
    }

    /**
     * 解题思路
     * (1) binary search aim distance
     * (2) use binary search to count pair
     *
     * time complexity: O(nlogn)
     * space complexity: O(n)
     */
    public int smallestDistancePairSecondSolution(int[] nums, int k) {
        Arrays.sort(nums);
        int maxDis = nums[nums.length - 1] - nums[0];
        int minDis = maxDis + 1;
        //找到最小距离
        for (int i = 1; i < nums.length; i++) {
            minDis = Math.min(minDis, nums[i] - nums[i - 1]);
        }
        while (minDis < maxDis) {
            int mid = minDis + (maxDis - minDis) / 2;
            //第k小的数字==> 前边有k-1个数字小于距离s ==> k个数字小于等于s
            if (countPair(nums, mid) < k) {
                minDis = mid + 1;

            } else {
                maxDis = mid;
            }
        }
        return minDis;
    }


    /**
     * 返回小于等于mid的配对数
     *
     * @param nums
     * @param mid
     * @return
     */
    private int countPair(int[] nums, int mid) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int d = upperBound(nums, i, nums[i] + mid);
            res += d - 1 - i;
        }
        return res;
    }

    //从i开始，返回第一个比aim大的索引
    private int upperBound(int[] nums, int i, int aim) {
        if (nums[nums.length - 1] < aim) {
            return nums.length;
        }
        int left = i;
        int right = nums.length - 1;
        //[left,right]
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= aim) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     *
     * 解题思路:
     * (1) binary search aim distance
     * (2) use two points find all distance which less than or equal with mid
     *
     * time complexity: O(nlogn)
     * space complexity: O()
     */
    public int smallestDistancePairThird(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length-1] - nums[0];
        // 目标值必在[0,max]上，所以不需要设置最小值
        int min = 0;
        //[min,max]查找返回值
        while(min < max){
            int mid = min + (max - min) / 2;
            //双指针[left,right]搜索所有小于等于mid pair的个数
            int left = 0;
            // count the numbers of pair <= mid
            int count = 0;
            // every right correspond with left
            // left to right 没有重复，都是以right为参照
            for(int right=1;right<nums.length;right++){
                //find left
                while(nums[right] - nums[left] > mid){
                    left++;
                }
                count += right - left;
            }
            // count > k => k smallest:
            if(count >= k){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().smallestDistancePairSecondSolution(new int[]{62, 100, 4}, 2));
    }
}
