package binarysearch;

import quiksort.QuikSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Wangpl
 * Time 2018/8/28 14:17
 */
public class BinarySearch {

    public static final int ARRAY_SIZE = 20;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
        array[6] = 50;
        QuikSort.quiksort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

        int result = binarySearch(array, 50);
        System.out.println(result);

    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int midVal = arr[middle];

            if (midVal < key) {
                low = middle + 1;
            }
            else if (midVal > key) {
                high = middle - 1;
            }
            else
                return middle;
        }
        return - (low + 1);
    }
}
