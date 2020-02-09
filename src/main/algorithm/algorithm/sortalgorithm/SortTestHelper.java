package sortalgorithm;

import java.lang.reflect.Method;
import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/2/5
 * @description:
 */
public class SortTestHelper {
    private SortTestHelper() {

    }

    public static Integer[] generateRandomArr(int rangeL, int rangeR, int n) {
        assert rangeL < rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }
        return arr;
    }

    public static void printArr(Object[] arr) {
        stream(arr).forEach(a -> System.out.print(a + " "));
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void sortReflect(String sortClassName, String methodName, Comparable[] arr) {
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod(methodName, Comparable[].class);
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            assert isSorted(arr);
            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
