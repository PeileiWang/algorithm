package 小米;

import java.util.Scanner;

/**
 * 比较两个数有多少位不同
 * Created by Wangpl
 * Time 2018/9/8 21:30
 */
public class 二进制 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();

        int result = countBitDiff(m, n);
        System.out.println(result);

    }

    private static int countBitDiff(int m, int n) {
        int tmp = m^n;
        int num = 0;
        for (int i = 0; i < 32; i++, tmp = tmp >> 1) {
            if((tmp & 1) == 1)
                num++;
        }
        return num;
    }
}
