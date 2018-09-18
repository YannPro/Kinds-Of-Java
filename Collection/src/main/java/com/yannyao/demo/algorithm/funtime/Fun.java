package com.yannyao.demo.algorithm.funtime;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Auther: YJY
 * @Date: 2018/9/14 14:30
 * @Description:
 */
public class Fun {

    static Card ACard = new Card("A", 0.19F);
    static  Card BCard = new Card("B", 0.19F);
    static Card CCard = new Card("C", 0.19F);
    static Card DCard = new Card("D", 0.19F);
    static Card ECard = new Card("E", 0.19F);
    static Card FCard = new Card("F", 0.05F);
    static List<Card> ABCEDList = new ArrayList<>();

    static List<Card> cardList = new ArrayList<>();
    public void init (){
        cardList.add(ACard);
        cardList.add(BCard);
        cardList.add(CCard);
        cardList.add(DCard);
        cardList.add(ECard);
        cardList.add(FCard);
        ABCEDList.add(ACard);
        ABCEDList.add(BCard);
        ABCEDList.add(CCard);
        ABCEDList.add(DCard);
        ABCEDList.add(ECard);
    }
    public Card getCard(){
        int r = (int)(Math.random() * 6);
        return cardList.get(r);
    }
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Fun fun = new Fun();
        fun.init();

        int totalABCDE = 0 , totalABCDEF = 0;

        List<Card> hasCardList = new ArrayList<>();

        int countABCDE = 0;

        while (true) {
            while(true){
                hasCardList.add(fun.getCard());
                totalABCDE++;
                if (hasCardList.contains(ABCEDList)) {
                    printList(hasCardList);

                    countABCDE++;
                    break;
                }
            }
//            hasCardList = new ArrayList<>();
            if (countABCDE >= 2) {
                break;
            }
        }
//        int countABCDEF = 0;
//        while (true) {
//            hasCardList = new ArrayList<>();
//            while (!hasCardList.contains(cardList)) {
//                totalABCDEF++;
//                hasCardList.add(fun.getCard());
//                countABCDEF++;
//            }
//            hasCardList = new ArrayList<>();
//            if (countABCDEF >= 10000000) {
//                break;
//            }
//        }

        System.out.println("totalABCDE:"+totalABCDE);

        System.out.println("totalABCDEF:"+totalABCDEF);
        Long end = System.currentTimeMillis();
        Long total = end - start;
        System.out.println("用时:" + total/1000 +"s");
    }
    public static void printList(List<Card> list){
        list.forEach(card -> {
            System.out.print(card.getName()+",");
        });
        System.out.println("------------");
    }
}
