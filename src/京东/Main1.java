package 京东;

import java.util.Scanner;

/**
 * Created by WangPeilei
 * Time 2018/9/9 20:20
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] arrays = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arrays[i][j] = input.nextInt();
            }
        }

        int totalNum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (notQuality(arrays[i], arrays[j])) {
                        totalNum++;
                        break;
                    }
                }
            }
        }
        System.out.println(totalNum);


    }

    private static boolean notQuality(int[] array, int[] array1) {
        return array[0] < array1[0]
                && array[1] < array1[1]
                && array[2] < array1[2];
    }
}

