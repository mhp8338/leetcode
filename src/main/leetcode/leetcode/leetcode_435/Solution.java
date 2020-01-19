package leetcode_435;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/12
 * @description: 动态归化
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int[] memo =  new int[n];
        Arrays.fill(memo,1);
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if(intervals[j][1]<=intervals[i][0]){
                    memo[i] = Math.max(memo[i],1+memo[j]);
                }
            }
        }

        int res = 1;
        for (int i=0;i<n;i++){
            res = Math.max(memo[i],res);
        }
        return n-res;
    }
}
