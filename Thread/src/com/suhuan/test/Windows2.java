package com.suhuan.test;

/**
 * @Auther: suhuan
 * @Date: 2022/10/10 - 10 - 10 - 22:15
 */
public class Windows2 implements Runnable{
    //比较继承
    //实现的要好一点，开发中优先选择实现Runnable接口的方式，没有单继承的局限性，多线程处理共享数据的情况

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket != 0) {
                System.out.println(Thread.currentThread().getName()+"还剩" + ticket-- + "张票");
            } else {
                break;
            }
        }
    }
}
class Test2{
    public static void main(String[] args) {
        Windows2 w = new Windows2();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
