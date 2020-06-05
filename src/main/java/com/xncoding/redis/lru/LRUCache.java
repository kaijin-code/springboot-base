package com.xncoding.redis.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private final int cacheSize;

    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(4);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four");

        cache.put(2, "two");
        System.out.println(cache.values());
    }
}
