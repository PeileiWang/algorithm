package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
 * 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，
 * 数组中第i个元素（prices[i]）代表该股票第i天的股价。
 * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
 * 若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 * Created by Wangpl
 * Time 2018/9/8 21:35
 */
public class 风口的猪_中国牛市 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArrays = str.split(",");
        int[] arrys = new int[strArrays.length];

        for (int i = 0; i < arrys.length; i++) {
            arrys[i] = Integer.parseInt(strArrays[i]);
        }

        int result = calculateMax(arrys);

        System.out.println(result);

    }

    /**
     * 贪心算法
     * @param arrys
     * @return
     */
    private static int calculateMax(int[] arrys) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int price : arrys) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        return secondSell;
    }
}
