package leetcode_435;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/12
 * @description: 贪心算法
 */
public class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int pre = intervals[0][1];
        int res = 1;
        for(int i = 1;i<n;i++){
            if(pre<=intervals[i][0]){
                res ++;
                pre = intervals[i][1];
            }
        }
        return n-res;
    }
}
