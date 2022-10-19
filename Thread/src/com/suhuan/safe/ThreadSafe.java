package com.suhuan.safe;

/**
 * @Auther: suhuan
 * @Date: 2022/10/11 - 10 - 11 - 23:19
 * 为啥会造成线程安全的问题：不同的线程操作共享的数据
 */
public class ThreadSafe {

    public static void main(String[] args) {
        //解决线程安全的方式1：同步代码块
        /*synchronized(同步监视器){
            //需要被同步的代码，即操作共享数据的代码，并不是将共享数据放进去而是要将操作共享数据的代码放入
            //共享数据：多个线程共同操作的数据
            //同步监视器：任何对象都可以,但是多个线程必须是同一把锁
            //缺点：虽然安全性高，但是效率低
        }*/
    }

}
