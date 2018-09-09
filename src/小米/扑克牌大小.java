package 小米;

import java.util.Scanner;

/**
 * Created by WangPeilei
 * Time 2018/9/9 8:35
 */
public class 扑克牌大小 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String str = input.nextLine();
        String[] cards = str.split("-");
        String[] firstCards = cards[0].split(" ");
        String[] secondCards = cards[1].split(" ");

        if (isJokers(firstCards) || isJokers(secondCards)) {
            System.out.println("joker JOKER");
        } else {
            if (firstCards.length == 4) {
                if (secondCards.length == 4) {
                    if (getOrder(firstCards[0]) > getOrder(secondCards[0])) {                     //order越大、牌面越大
                        printCards(firstCards);
                    } else {
                        printCards(secondCards);
                    }
                } else {
                    printCards(firstCards);
                }
            }
            else if (secondCards.length == 4) {
                printCards(secondCards);
            }
            else if (firstCards.length == secondCards.length) {
                if(getOrder(firstCards[0]) > getOrder(secondCards[0])) {
                    printCards(firstCards);
                }
                else {
                    printCards(secondCards);
                }
            } else {
                System.out.println("ERROR");
            }
        }

    }

    private static void printCards(String[] cards) {
        StringBuilder sb = new StringBuilder("");
        for (String card : cards) {
            sb.append(card).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int getOrder(String card) {
        return "345678910JQKA2jokerJOKER".indexOf(card);
    }

    private static boolean isJokers(String[] cards) {
        if (2 == cards.length) {
            return "joker".equals(cards[0]) || "JOKER".equals(cards[1]);
        }
        return false;
    }
}
