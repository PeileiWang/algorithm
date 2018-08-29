package quicksort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by Wangpl
 * Time 2018/8/29 17:46
 */
public class ObjectQuickSort {

    public static final int STUDENT_SIZE = 15;

    public static void main(String[] args) {
        Random random = new Random();
        Student[] students = new Student[STUDENT_SIZE];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setId(random.nextInt(50));
            students[i].setName(String.valueOf(random.nextInt(100)) + "user");
        }


        System.out.println(Arrays.toString(students));
        quickSort(students);
        System.out.println(Arrays.toString(students));

    }


    public static <T extends Comparable<T>> void quickSort(T[] array){
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        T temp = array[left];

        while (i < j) {
            while (array[j].compareTo(temp) >= 0 && i < j)
                j--;
            while (array[i].compareTo(temp) <= 0 && i < j)
                i++;
            if (i < j) {
                T t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        array[left] = array[i];
        array[i] = temp;

        quickSort(array, left, i - 1);
        quickSort(array, left + 1, right);
    }
}
