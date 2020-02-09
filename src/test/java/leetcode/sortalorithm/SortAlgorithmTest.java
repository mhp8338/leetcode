package sortalorithm;

import org.junit.Test;
import sortalgorithm.SortAlgorithm;
import sortalgorithm.SortTestHelper;
import sortalgorithm.bean.Student;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/2/5
 * @description:
 */
public class SortAlgorithmTest {

    @Test
    public void selection_sort_test() {
        Integer[] arr = {9,8,7,6,5,4};
        SortAlgorithm.selectionSort(arr);
        SortTestHelper.printArr(arr);
        System.out.println();

        Double[] b = {2.2,3.3,1.3,4.4};
        SortAlgorithm.selectionSort(b);
        SortTestHelper.printArr(b);
        System.out.println();

        String[] s = {"D","B","A","C"};
        SortAlgorithm.selectionSort(s);
        SortTestHelper.printArr(s);
        System.out.println();

        Student[] students = new Student[4];
        students[0] = new Student("mmm",97);
        students[1] = new Student("ma",91);
        students[2] = new Student("maa",92);
        students[3] = new Student("maaa",93);
        SortAlgorithm.selectionSort(students);
        SortTestHelper.printArr(students);
    }

    @Test
    public void generate_random_arr_test(){
        Integer[] integers = SortTestHelper.generateRandomArr(0, 100, 100);

        SortAlgorithm.selectionSort(integers);
        SortTestHelper.printArr(integers);
    }

    @Test
    public void sort_reflect_test(){
        Integer[] arrs = SortTestHelper.generateRandomArr(0,100,100);
        SortTestHelper.sortReflect("sortalgorithm.SortAlgorithm","selectionSort",arrs);
        SortTestHelper.printArr(arrs);
    }
}