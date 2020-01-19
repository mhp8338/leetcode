package leetcode_347;

import java.util.*;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/19
 * @description:
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //底层实现的是最小堆，优先取出最小的元素，但元素之间的比较是可定的，此处
        //比较方法直接选用数值大小的比较（若最大堆，则选择数值大小相反的比较方法）
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->map.get(a)-map.get(b));

        for(Integer num:map.keySet()){
            q.add(num);
            if(q.size()>k){
                q.remove();
            }
        }

        List<Integer> res = new LinkedList<>();
        while(!q.isEmpty()){
            res.add(q.remove());
        }
        return res;
    }
}
