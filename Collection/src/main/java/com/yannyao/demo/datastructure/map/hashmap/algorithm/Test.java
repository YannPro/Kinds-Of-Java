package com.yannyao.demo.DataStructure.Map.hashmap.Algorithm;

import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.util.*;

public class Test {
    /*ArrayList去重方法一*/
//    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);}};
//        List<Integer> b = new ArrayList<Integer>(){{add(1);add(2);add(3);add(5);add(6);}};
//        Iterator it = a.iterator();
//        Iterator it2 = b.iterator();
//        while(it.hasNext()){
//            while(it.hasNext()){
//                if(it.next() == it2.next()){
//                    it.remove();
//                    it2.remove();
//                }
//            }
//        }
//        System.out.println(a);
//        System.out.println(b);
//    }
    /*ArrayList去重方法二*/
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);}};
        List<Integer> b = new ArrayList<Integer>(){{add(1);add(2);add(3);add(5);add(6);}};
        Set set = new HashSet();
        set.addAll(a);
        set.addAll(b);
        List la = new ArrayList(set);
        List lb = new ArrayList(set);
        la.removeAll(a);
        lb.removeAll(b);
        System.out.println(la+","+lb);

    }
}
