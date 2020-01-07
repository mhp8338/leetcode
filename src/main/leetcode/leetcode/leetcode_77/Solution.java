package leetcode_77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77.Combination
 * https://leetcode.com/problems/combinations/description/
 * 组合问题
 * 回朔法
 * Space:O(k)
 * Time:O(n^k)
 *
 * @author xuepipi
 */
class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        LinkedList<Integer> p = new LinkedList<>();
        generateCombine(n, k, 1, p);
        return res;
    }

    /**
     * 求解C(n,k),目前已经找到的组合存在p中，从start开始重新搜索元素
     *
     * @param n     n个数字
     * @param k     去k个组合
     * @param start 搜索起点
     * @param p     临时数组，存储组合
     */
    private void generateCombine(int n, int k, int start, LinkedList<Integer> p) {
        /*
        找到第一个组合
         */
        if (p.size() == k) {
            res.add((LinkedList<Integer>) p.clone());
            return;
        }

        /*
        - 从[i,n]搜索p后边的组合
        - [i,n]至少要有k-p.size()个数
        - i最多为n-(k-p.size())+1
        将i<=n设为i <= n - (k - p.size()) + 1做了一个剪枝操作
        */
        for (int i = start; i <= n - (k - p.size()) + 1; i++) {
            System.out.println("Start i=" + i);
            System.out.println("p.size()=" + p.size() + ",n-(k-p.size())+1=" + (n - (k - p.size()) + 1));
            p.addLast(i);
            System.out.println("After p.addLast(i),p=" + p);
            generateCombine(n, k, i + 1, p);
            System.out.println("After generateCombine,p=" + p);
            p.removeLast();
            System.out.println("After removeLast,p=" + p);

        }
    }

    public static void main(String[] args) {
        new Solution().combine(8, 6);
    }
}
