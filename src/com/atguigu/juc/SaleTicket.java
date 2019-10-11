package com.atguigu.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int numeber = 30;
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (numeber > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (numeber--) + "\t还剩下：" + numeber);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


}

/**
 * @author qjx
 * @create 2019-10-11 18:24
 **/
//1.高内聚，低耦合的前提下， 线程   操作     资源类
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {for(int i=1;i<=40;i++) ticket.sale();},"a").start();
        new Thread(() -> {for(int i=1;i<=40;i++) ticket.sale();},"b").start();
        new Thread(() -> {for(int i=1;i<=40;i++) ticket.sale();},"c").start();
    }


}
