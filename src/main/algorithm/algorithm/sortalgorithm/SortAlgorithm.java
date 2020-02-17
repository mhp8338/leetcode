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
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void insertionSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0; j--) {
//                if(arr[j].compareTo(arr[j-1])<0){
//                    swap(arr,j,j-1);
//                }else{
//                    break;
//                }
//            }

//            for (int j = i; j >0 && arr[j].compareTo(arr[j-1])<0 ; j--) {
//                swap(arr,j,j-1);
//            }

            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = e;

        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArr(0, 100000, N);
        SortTestHelper.sortReflect("sortalgorithm.SortAlgorithm", "insertionSort", arr);
        SortTestHelper.printArr(arr);
    }

}
