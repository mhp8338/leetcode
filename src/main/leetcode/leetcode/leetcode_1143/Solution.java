package leetcode_1143;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/1/11
 * @description:
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m == 0 || n == 0){
            return 0;
        }

        // m、n的公共最长子序列
        int[][] memo = new int[m][n];
        for(int i=0;i<n;i++){
            if(text1.charAt(0) == text2.charAt(i)){
                for(int k = i;k<n;k++){
                    memo[0][k] = 1;
                }
            }
        }
        for(int i=0;i<m;i++){
            if(text1.charAt(i) == text2.charAt(0)){
                for(int k = i;k<m;k++){
                    memo[k][0] = 1;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    memo[i][j] = memo[i-1][j-1]+1;
                }else{
                    memo[i][j] = Math.max(memo[i][j-1],memo[i-1][j]);
                }
            }
        }

        return memo[m-1][n-1];

    }
}
