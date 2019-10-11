package com.atguigu.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author qjx
 * @create 2019-10-11 20:08
 **/
public class NotSafeDemo {
    public static void main(String[] args) {
       // List<String> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list = new Vector<>();
        List<String> list=new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }
}
