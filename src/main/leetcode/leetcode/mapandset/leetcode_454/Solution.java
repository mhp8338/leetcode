package mapandset.leetcode_454;

import java.util.HashMap;
import java.util.Map;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/18
 * @description:
 */
public class Solution {
    /**
    Time:O(n^2)
    Space:O(n^2)
    */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        //<A[i]+B[j],count>
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }

        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                if(map.containsKey(-C[i]-D[j])){
                    res += map.get(-C[i]-D[j]);
                }
            }
        }
        return res;
    }
}
