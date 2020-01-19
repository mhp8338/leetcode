package leetcode_455;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/13
 * @description: 455. Assign Cookies
 * 贪心算法
 */
public class Solution {
    /**
     * @param g 小孩
     * @param s 饼干
     * @return 最多能满足多少个小孩
     */
    public int findContentChildren(int[] g, int[] s) {
        int childNum = g.length;
        int cookieNum = s.length;

        if(childNum==0||cookieNum==0){
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        /*题目初衷：让更多的小朋友满意，所以应该设法考虑到所有的小孩，
        故贪心算法设计如下：将最大的饼干分给最贪心的小朋友，确保每个小朋友都考虑到*/
        while (childNum>=1&&cookieNum>=1){
            if(g[childNum-1]<=s[cookieNum-1]){
                cookieNum--;
                res ++;
            }
            childNum--;
        }

        return res;

    }
}
