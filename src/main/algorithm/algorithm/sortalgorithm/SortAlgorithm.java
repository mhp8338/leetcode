package sortalgorithm;

import java.util.Arrays;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/2/5
 * @description:
 */
public class SortAlgorithm {
    /**
     * @param arr 选择排序算法 O(n^2)
     */
    public static void selectionSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            /*[i,n-1]中找到最小值交换位置*/
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[minIndex].compareTo(arr[j])>0){
                    minIndex  = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
