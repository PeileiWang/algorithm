package 京东;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by WangPeilei
 * Time 2018/9/9 18:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        int num = Integer.parseInt(string);
        int N;
        int M;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set.clear();
            String string1 = input.nextLine();
            String[] strings = string1.split(" ");
            N = Integer.parseInt(strings[0]);
            M = Integer.parseInt(strings[1]);
            int[] arrays = new int[M * 2];
            for (int j = 0; j < arrays.length/2; j++) {
                arrays[j] = input.nextInt();
                set.add(arrays[j]);
            }

            int[] ints = new int[N];
            for (int k = 0; k < arrays.length; k++) {
                if (set.contains(arrays[k])) {
                    ints[arrays[k] - 1]++;
                }
            }

            boolean flag = false;

            for (int j = 0; j < ints.length; j++) {
                if (ints[j] % 2 != 0) {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }
}
