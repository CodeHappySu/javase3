package com.suhuan.thread;

/**
 * @Auther: suhuan
 * @Date: 2022/10/10 - 10 - 10 - 21:24
 */
public class Thread02 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);//这他娘的用的是代理模式
        thread.start();
    }

}
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
