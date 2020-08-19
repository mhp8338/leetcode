package mapandset.leetcode_447;

import java.util.HashMap;
import java.util.Map;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/18
 * @description:
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length<3){
            return 0;
        }
        int res = 0;

        for(int i=0;i<points.length;i++){
            //<距离，频次>
            Map<Integer,Integer> map = new HashMap<>();
            int j = 0;
            while(j<points.length){
                if(j==i){
                    j++;
                    continue;
                }
                int dist = getDist(i,j,points);
                map.put(dist,map.getOrDefault(dist,0)+1);
                j++;
            }
            /*
            * 组合排序An2
            * */
            for(int v:map.values()){
                res += v * (v - 1);
            }
        }
        return res;
    }
    private int getDist(int i,int j,int[][] points){
        int[] x = points[i];
        int[] y = points[j];
        return (x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]);
    }
}
