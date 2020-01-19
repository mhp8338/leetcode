package leetcode_1143;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/12
 * @description: 递归解法
 */
public class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return findLongestSubsequence(text1, text2, m - 1, n - 1);
    }

    /**
     * @param text1 text1
     * @param text2 text2
     * @param a     text1[0,a]
     * @param b     text2[0,b]
     * @return text1[0,a] text2[0,b]的最长子序列
     */
    private int findLongestSubsequence(String text1, String text2, int a, int b) {
        if (a < 0 || b < 0) {
            return 0;
        }

        int res = 0;
        /*状态转移方程*/
        if (text1.charAt(a) == text2.charAt(b)) {
            res = 1 + findLongestSubsequence(text1, text2, a - 1, b - 1);
        } else {
            res = Math.max(findLongestSubsequence(text1, text2, a - 1, b),
                    findLongestSubsequence(text1,text2,a,b-1));
        }
        return res;
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(new Solution1().longestCommonSubsequence(text1,text2));
    }
}
