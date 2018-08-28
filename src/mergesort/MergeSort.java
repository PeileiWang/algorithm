package mergesort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Wangpl
 * Time 2018/8/28 13:19
 */
public class MergeSort {

    public static final int ARRAY_SIZE = 30;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(array));

        sort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];   //排序前，建立好一个长度等于原数组长度的临时数组
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //左序列指针
        int j = mid + 1;    //有序列指针
        int t = 0;  //临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
