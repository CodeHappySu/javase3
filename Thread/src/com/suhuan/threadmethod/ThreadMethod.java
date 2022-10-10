package com.suhuan.threadmethod;

/**
 * @Auther: suhuan
 * @Date: 2022/10/10 - 10 - 10 - 20:14
 */
public class ThreadMethod {

    public static void main(String[] args) {
        Thread.currentThread().setName("============main线程");
        Thread01 t1 = new Thread01("Thead01");
        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);//不一定优先级高的线程就先获得CPU的执行权
        t1.setPriority(Thread.currentThread().MIN_PRIORITY);
        for (int i = 100; i < 200; i++) {//主线任务
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i == 150) {
                try {
                    t1.join();//我在A线程中调用join方法，表示我要先执行我的线程任务,A线程再继续执行之后的任务
                    //yield方法只是释放了CPU的执行权，这个时候再一次让他们争夺CPU的执行权
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Thread01 extends Thread {

    private String name;

    public Thread01(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {//子线程任务
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ":" + i);
            if (i == 50) {
                try {
                    this.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
}
            }
                    }
                    }
}

