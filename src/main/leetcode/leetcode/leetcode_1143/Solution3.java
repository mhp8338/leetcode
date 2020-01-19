package leetcode_1143;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/12
 * @description:
 */
public class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        /*
        * memo[i][j]表示text1前i个数字和text2的前j个数字的longestCommonSubsequence
        * 其中memo[0][0]时都为0，所以都为空默认为零
        * */
        int[][] memo = new int[m+1][n+1];
        for (int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1] + 1;
                }else{
                    memo[i][j] = Math.max(memo[i-1][j],memo[i][j-1]);
                }
            }
        }
        return memo[m][n];


    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(new Solution3().longestCommonSubsequence(text1, text2));
    }
}
