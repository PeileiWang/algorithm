package quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Wangpl
 * Time 2018/8/28 13:17
 */
public class QuickSort {

    public static final int ARRAY_SIZE = 30;

    public static void main(String[] args) {
        int[] array = new int[30];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(500);
        }
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        int temp = array[left];

        while (i < j) {
            while (array[j] >= temp && i < j) {
                j--;
            }
            while (array[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        array[left] = array[i];
        array[i] = temp;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
}

