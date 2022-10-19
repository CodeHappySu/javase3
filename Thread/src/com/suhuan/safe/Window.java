package com.suhuan.safe;

/**
 * @Auther: suhuan
 * @Date: 2022/10/19 - 10 - 19 - 23:15
 */
public class Window implements Runnable {

    private int ticket = 100;
    private boolean flag = true;

    @Override
    public void run() {
        while (true) {
            if (flag) {
                show();
            } else {
                break;
            }
        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "的票还剩" + ticket--);
        } else {
            flag = false;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Window w = new Window();
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
