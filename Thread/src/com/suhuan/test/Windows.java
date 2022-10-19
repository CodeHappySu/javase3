package com.suhuan.test;

/**
 * @Auther: suhuan
 * @Date: 2022/10/10 - 10 - 10 - 21:12
 */
public class Windows extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();
    private String name;

    public Windows(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + "还剩" + ticket-- + "张票");
                } else {
                    break;
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Windows w1 = new Windows("窗口1");
        Windows w2 = new Windows("窗口2");
        Windows w3 = new Windows("窗口3");
        w1.start();
        w2.start();
        w3.start();
        //但是还是存在一些问题（如下结果），怎么解决呢？
        /*
            窗口1还剩100张票
            窗口1还剩98张票
            窗口2还剩97张票
            窗口3还剩99张票
            窗口3还剩94张票
            窗口3还剩93张票
        */
    }
}
