package leetcode_17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuepipi
 */
class Solution {
    private List<String> res = new ArrayList<>();
    private static final String[] NUMBER_DIGITS =
            {       // 0-9
                    " ",
                    "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz"
            };

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        letterCombinations(digits, 0, "");
        return res;
    }

    /**
     * @param digits 输入数字字符串
     * @param index  digits第index数字
     * @param s 暂存结果
     * s保存了[0,index-1]得到的字母串
     * 此函数将令s保存[0，index]相对应的字母串
     */
    private void letterCombinations(String digits, int index, String s) {
        System.out.println(index + ":" + s);
        /*
        index == digits.length() 说明已经回朔法到底层了,添加s，返回即可
         */
        if (index == digits.length()) {
            res.add(s);
            System.out.println("get " + s + " return");
            return;
        }
        char c = digits.charAt(index);
        //得到数字对应的字母
        String letter = NUMBER_DIGITS[c - '0'];
        for (int i = 0; i < letter.length(); i++) {
            System.out.println("digits["+index+"]="+c+",use "+letter.charAt(i));
            //每次循环都包含剪枝操作
            letterCombinations(digits, index + 1, s + letter.charAt(i));
        }
        //都结束返回，可有可无
        System.out.println("digits["+index+"]="+c+" complete,return");
        return;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("234"));
    }
}
