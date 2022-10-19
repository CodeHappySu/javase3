package com.suhuan.thread;

import java.lang.annotation.Target;

/**
 * @Auther: suhuan
 * @Date: 2022/10/19 - 10 - 19 - 22:26
 */
public class ThreadTest {

    public static void main(String[] args) {
        A a = new A();
        Thread01 t = new Thread01(a);
        Thread01 t1 = new Thread01(a);
        Thread01 t2 = new Thread01(a);
        t.run();//这个run方法并不是调用线程里面的而是通过调用run方法，然后让里面的实现Runable接口的实现类去调
        t1.run();
        t2.run();
    }

}
interface Runable{
    void run();
}
class Thread01{

    private Runable target;

    public Thread01(Runable target){
        this.target = target;
    }

    public void run(){
        if(target != null){
            target.run();
        }
    }

}
class A implements Runable{

    private Object obj = new Object();

    @Override
    public void run() {
        System.out.println(obj);
    }
}

