package com.suhuan.test;

/**
 * @Auther: suhuan
 * @Date: 2022/10/10 - 10 - 10 - 22:00
 */
public class Test01 {//学习创建线程的第二种方法后代理模式复习

    public static void main(String[] args) {
        Worker suhuan = new Boss("苏欢");
        Lower lower = new Lower(suhuan);
        lower.work();
    }

}
interface Worker{
    void work();
}
class Lower implements Worker{

    private String name;
    private Worker worker;

    public Lower(Worker worker){
        this.worker = worker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void accredit(){
        System.out.println("授权中...");
    }
    private void endWork(){
        System.out.println("律师结束工作");
    }

    @Override
    public void work() {
        accredit();
        worker.work();
        endWork();
    }
}
class Boss implements Worker{

    private String name;

    public Boss(String name){
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name+"正在工作...");
    }
}
