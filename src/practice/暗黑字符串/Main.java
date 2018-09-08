package practice.暗黑字符串;

import java.util.Scanner;

/**
 * Created by Wangpl
 * Time 2018/9/6 23:10
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if (n == 1) {
            System.out.println(3);
            return;
        }

        long[] dp = new long[n];

        dp[0] = 3;
        dp[1] = 9;

        for (int i = 2; i < n; i++) {
            dp[i] = 2 * dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n-1]);
    }

}
