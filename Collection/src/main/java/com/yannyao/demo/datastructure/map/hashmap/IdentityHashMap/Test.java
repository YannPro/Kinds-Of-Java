package com.yannyao.demo.DataStructure.Map.hashmap.IdentityHashMap;

import java.util.*;

public class Test {
    //IdentityHashMap 允许键重复
    public static void main(String[] args) {
        Map<String, String> identityHashMap = new IdentityHashMap<String, String>();
        identityHashMap.put(new String("1"), "a");
        identityHashMap.put(new String("2"), "b");
        identityHashMap.put(new String("1"), "c");
        Iterator iterator = identityHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println("key: "+entry.getKey()+"  vlaue: "+entry.getValue());
        }
    }

}
