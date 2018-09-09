package 小米;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by WangPeilei
 * Time 2018/9/9 14:07
 */
public class 首个重复字母 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] splitStr = str.split(",");
        String s = splitStr[0].replace("\"", "");
        String cmp = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        BitSet bs = new BitSet(cmp.length());
        for (int i = 0; i < s.length(); i++) {
            int index = cmp.indexOf(s.charAt(i));
            if (bs.get(index)) {
                System.out.println(cmp.charAt(index));
                break;
            } else {
                bs.set(index, true);
            }
        }
    }
}
