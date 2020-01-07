package leetcode_46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xuepipi
 */
class Solution {
    /**
     * 排列问题
     * res:存储返回值
     * used:判断元素是否使用，如果使用则不再考虑
     */
    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        if(nums.length==0){
            return res;
        }
        LinkedList<Integer> p = new LinkedList<>();
        used = new boolean[nums.length];
        generatePermute(nums,0,p);
        return res;
    }

    /**
     * 不断向排列p末尾添加index元素
     * @param nums  输入数组
     * @param index 添加第index个元素到p
     * @param p 临时数组，用以存储[0,index]元素的排列的一种情况
     */
    private void generatePermute(int[] nums,int index,LinkedList<Integer> p){
        /*
        当index满时，说明已经获得一个解
        此时添加至res中，
        注意：clone是为了防止后续对p的修改，影响res的值
         */
        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        for(int i=0;i<nums.length;i++){
            //如果未使用
            if(!used[i]){
                System.out.println("p="+p);
                p.addLast(nums[i]);
                System.out.println("nums[i]="+nums[i]);
                used[i] = true;
                //递归调用填入index+1的值
                generatePermute(nums,index+1,p);
                System.out.println("After generatePermute,p="+p);
                //回朔，回到先前的状态
                //包括删除后节点，以及使用状态的重置
                System.out.println("removeLast:"+p.removeLast());
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Solution().permute(nums));
    }
}
