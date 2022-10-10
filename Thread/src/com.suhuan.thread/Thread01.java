package com.suhuan.thread;

import org.junit.jupiter.api.Test;

/**
 * @Auther: suhuan
 * @Date: 2022/10/8 - 10 - 08 - 20:14
 * 程序、进程和线程的理解
 */
public class Thread01 extends Thread {//创建线程方式1：继承Thread

    @Override
    public void run() {//必须重写父类的run方法
        //run方法里面是线程的具体操作
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}

class Test1 {

    public static void main(String[] args) {
        Thread01 t = new Thread01();
        //1.启动当前线程2.调用当前线程的run();并且该方法只能被调用一次
        t.start();
        //如果再启动一个线程那么重新new一个就行了,这里我用了匿名子类方式
        new Thread() {//这样做的好处是这个t2对象只能
            @Override
            public void run() {
                for (int i = 100; i < 200; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }.start();
        //t.run();//这样的话就是按顺序单线程执行了
        //但是为啥不能直接调用run方法呢，因为直接调用不是多线程而是单线程了
        //这个for循环在main线程中运行
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

}
