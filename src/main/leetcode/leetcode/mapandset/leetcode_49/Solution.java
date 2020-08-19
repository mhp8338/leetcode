package mapandset.leetcode_49;

import java.util.*;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/8/18
 * @description:
 */
class Solution {
    private List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return new ArrayList<>();
        }
        if(strs.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>(0);
        for(String str:strs){
            //int[]错了
            int[] freq = new int[26];
            for(char c: str.toCharArray()){
                freq[c-'a']++;
            }
            String strValue = Arrays.toString(freq);
//            String strValue = String.valueOf(freq);
            if(!map.containsKey(strValue)){
                map.put(strValue,new ArrayList<>());
            }
            map.get(strValue).add(str);
        }
        return new ArrayList(map.values());

    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
