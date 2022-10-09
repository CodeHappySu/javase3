package com.suhuan.test;

/**
 * @Auther: suhuan
 * @Date: 2022/10/9 - 10 - 09 - 23:12
 */
public class ThreadTest01 {

    //创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数(不同的线程执行的任务不同)
    //传统继承的方法，只能创建两个线程类，有没有新的方法呢
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }

}
