package com.yannyao.demo.luban;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: YJY
 * @Date: 2018/12/2 19:27
 * @Description:
 */
public class MyHashMap<K,V> {

    private Entry<K,V>[] table;

    private static final Integer CAPACITY = 8;

    private int size;

    public V get(K k){
        //存entry
        int hashCode = hash(k);
        int index = indexFor(hashCode);

        for(Entry<K,V> entry = table[index]; entry!=null;entry=entry.next){
            if(entry.key.equals(k)){
                return entry.value;
            }
        }
        return null;
    }
    public void put(K k, V v){
        if (table == null) {
            inflate();
        }

        //存entry
        int hashCode = hash(k);
        int index = indexFor(hashCode);

        for(Entry<K,V> entry = table[index]; entry!=null;entry=entry.next){
            if(entry.key.equals(k)){
                entry.key = k;
            }
        }
        addEntry(k,v, index);
    }

    private void addEntry(K k,V v, int index){
        Entry<K,V> entry = new Entry<>(k, v, table[index]);
        table[index] = entry;
        size++;
    }
    private int indexFor(int hashCode){
        return hashCode%table.length;
    }
    private int hash(K k){
        return k.hashCode();
    }
    private void inflate(){
        table = new Entry[CAPACITY];
    }
    class Entry<K,V> {
        public K key;
        public V value;
        public Entry<K,V> next;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Map h = new HashMap();
        h.put("d","d");
    }
}

