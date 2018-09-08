package 小米;

import java.util.Scanner;

/**
 * Created by Wangpl
 * Time 2018/9/8 22:13
 */
public class 最高分 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str1 = input.nextLine();
            String[] str1s = str1.split(" ");
            int m = Integer.parseInt(str1s[0]);
            int n = Integer.parseInt(str1s[1]);
            String str2 = input.nextLine();
            String[] str2s = str2.split(" ");
            int[] arrays = new int[m];
            for (int i = 0; i < m; i++) {
                arrays[i] = Integer.parseInt(str2s[i]);
            }

            for (int i = 0; i < n; i++) {
                String str3 = input.nextLine();
                String[] str3s = str3.split(" ");
                String str = str3s[0];
                int a, b;
                a = Integer.parseInt(str3s[1]);
                b = Integer.parseInt(str3s[2]);
                switch (str) {
                    case "Q":
                        int res = findMax(arrays, a, b);
                        System.out.println(res);
                        break;
                    case "U":
                        setNum(arrays, a, b);
                        break;
                }
            }
        }


    }

    /**
     * 设置位置a的值为b
     * @param arrays
     * @param a
     * @param b
     */
    private static void setNum(int[] arrays, int a, int b) {
        arrays[a-1] = b;
    }

    /**
     * 找到索引a、b之间最大的
     * @param arrays
     * @param a
     * @param b
     */
    private static int findMax(int[] arrays, int a, int b) {
        int max = Integer.MIN_VALUE;
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int i = a - 1; i < b; i++) {
            max = Math.max(max, arrays[i]);
        }
        return max;
    }
}
