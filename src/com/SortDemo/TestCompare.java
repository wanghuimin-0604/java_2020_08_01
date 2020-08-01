package SortDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-09
 * Time:15:31
 * 一万年太久，只争朝夕，加油
 */
/*class Card implements Comparable<Card> {
    public String rank;//数值
    public String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }*/
/*
    @Override
    public boolean equals(Object obj) {
        //1、先比较两个身分是否相同
        if (this == obj) {
            return true;
        }
        //2、如果obj为空
        if (obj == null) {
            return false;
        }
        //3、obj是否能强转成Card
        if (!(obj instanceof Card)) {
            return false;
        }
        //4、类型转换
        Card other = (Card) obj;

        return this.rank.equals(other.rank);
    }*/
class Card{
    public String rank;//数值
    public String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    class CardComparator implements Comparator<Card>{

        @Override
        public int compare(Card o1, Card o2) {
            int rank1 = o1.conventCard();
            int rank2 = o2.conventCard();
            return rank1-rank2;
        }
    }

    /*@Override
    public int compareTo(Card o) {
        //this<0  返回小于0
        //this>o  返回大于0
        //this==o 返回0
        //定义规则  按照扑克牌的点数进行比较
        int rank1 = this.conventCard();
        int rank2 = o.conventCard();
        return rank1 - rank2;
    }*/

    private int conventCard() {
        //把String转换成int
        if ("A".equals(rank)) {
            return 14;
        }
        if ("J".equals(rank)) {
            return 15;
        }
        if ("Q".equals(rank)) {
            return 16;
        }
        if ("K".equals(rank)) {
            return 17;
        }
        return Integer.parseInt(rank);
    }

//    @Override
//    public String toString() {
//        return "Card{" + "rank=" + rank + "," + "suit=" + suit + "}";
//    }


    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}

    public class TestCompare {
        public static void main(String[] args) {
            Card card1 = new Card("10", "♥");
            Card card2 = new Card("15", "♠");
            Card card3 = card1;
            /*System.out.println(card1 == card2);
            System.out.println(card1.equals(card2));
            System.out.println(card1 == card3);
            System.out.println(card1.equals(card3));
            System.out.println(card1.compareTo(card2));*/

           /* List<Card> cards = new ArrayList<>();
            cards.add(new Card("J", "♥"));
            cards.add(new Card("Q", "♥"));
            cards.add(new Card("K", "♥"));
            cards.add(new Card("A", "♥"));
            Collections.sort(cards, new CardComparator());
            System.out.println(cards.toString());*/
        }
    }