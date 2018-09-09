package 小米;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给[1,3,5,7,9],5,3
 * 输出1
 * 找到第一次出现的位置
 * Created by WangPeilei
 * Time 2018/9/9 9:13
 */
public class 二分查找 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        str = str.replace("[", "")
                .replace(",", " ")
                .replace("]", "");
        String[] strs = str.split(" ");
//        for (int i = 0; i < strs.length; i++) {
//            System.out.println(strs[i].trim());
//        }
        int[] nums = new int[strs.length - 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int target = Integer.parseInt(strs[strs.length - 1]);
        System.out.println(getPos(nums, nums.length, target));
    }

    public static int getPos(int[] A, int n, int val) {
        // write code here
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] < val) {
                low = mid + 1;
            } else if (A[mid] > val) {
                high = mid - 1;
            } else {
                high = mid;
            }
        }
        if(A[low] == val) return low;
        return -1;
    }
}
