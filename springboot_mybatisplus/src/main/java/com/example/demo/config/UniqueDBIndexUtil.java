package com.example.demo.config;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class UniqueDBIndexUtil {
    private static Long currentSeconds = getBaseTime();
    static LinkedList <Integer> indexList = new LinkedList();
    static LinkedList <Integer> indexPool=new LinkedList<>();
    private static Random r = new Random();

    static {
        for (int i = 0; i < 9999; i++) {
            indexList.add(i);
        }
        indexListInit();
    }

    public static void indexListInit() {
        for (Integer integer : indexList) {
            indexPool.add(integer);
        }
    }

    public synchronized static int getRandomIndex() {
        if (indexPool.size() <= 0) {
            indexListInit();
        }
        int random = r.nextInt(indexPool.size());
        Integer index = indexPool.get(random);
        indexPool.remove(index);
        return index;
    }

    public static Long generate() {
        long base = getBaseTime();
        if (getBaseTime() > currentSeconds) {
            indexListInit();
            currentSeconds = getBaseTime();
        }

        long postfix = (long) Math.floor(Math.random() * 10000);
        long finalIdx = base * 10000 + getRandomIndex();
        return finalIdx;
    }

    public static long getBaseTime() {
        return DateUtil.now().getTime() / 1000 - 1483200000;
    }


    public static void main(String[] args) {
        HashSet <Long> set = new HashSet <>();

        new Thread(() -> {
            for (int i = 0; i < 3333; i++) {
                Long id = UniqueDBIndexUtil.generate();
                if (set.contains(id)) {
                    System.out.println("ID已存在！！！！！！！！！！！！！！！！");
                    break;
                } else {
                    System.out.println(id);
                    set.add(id);
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 3333; i++) {
                Long id = UniqueDBIndexUtil.generate();
                if (set.contains(id)) {
                    System.out.println("ID已存在！！！！！！！！！！！！！！！！");
                    break;
                } else {
                    System.out.println(id);
                    set.add(id);
                }

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 3353; i++) {
                Long id = UniqueDBIndexUtil.generate();
                if (set.contains(id)) {
                    System.out.println("ID已存在！！！！！！！！！！！！！！！！");
                    break;
                } else {
                    System.out.println(id);
                    set.add(id);
                }

            }
        }).start();


    }
}
