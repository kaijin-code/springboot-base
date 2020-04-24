package com.xncoding.aqs;

import com.xncoding.aqs.queue.RoundQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTreeMap<K,V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentTreeMap.class);

    private final ReentrantLock lock;
    private RoundQueue<K> roundQueue;

    private TreeMap<K, V> tree;


    public ConcurrentTreeMap(int capacity, Comparator<? super K> comparator) {
        tree = new TreeMap<K, V>(comparator);
        roundQueue = new RoundQueue<K>(capacity);
        lock = new ReentrantLock(true);
    }

    public Map.Entry<K, V> pollFirstEntry() {
        lock.lock();
        try {
            return tree.pollFirstEntry();
        } finally {
            lock.unlock();
        }
    }

    public V putIfAbsentAndRetExsit(K key, V value) {
        lock.lock();

        try {
            if(roundQueue.put(key)){
                V exsit = tree.get(key);
                if(null == exsit){
                    tree.put(key, value);
                    exsit = value;

                }
                LOGGER.warn("putIfAbsentAndRetExsit success. " + key);
                return exsit;
            }else {
                return tree.get(key);
            }

        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        ConcurrentTreeMap<Integer,Object> map2 = new ConcurrentTreeMap<Integer, Object>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0; i < 100; i++){

            new Thread(()->{

                map2.putIfAbsentAndRetExsit(2, "a");
                map2.putIfAbsentAndRetExsit(3,"c");
                map2.putIfAbsentAndRetExsit(1, "b");
                countDownLatch.countDown();
            }).start();


        }
        countDownLatch.await();
        System.out.println(map2.pollFirstEntry());

        //long endTime = System.currentTimeMillis();
    }
}
