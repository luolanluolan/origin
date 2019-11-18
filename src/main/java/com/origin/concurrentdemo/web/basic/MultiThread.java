package com.origin.concurrentdemo.web.basic;

/**
 * @author LL
 * @date 2019/11/14 16:25
 * @describe  printNum(String name)方法加上synchronized修饰后，同一时刻只有一个线程能进入，
 * 但是输出结果：
 * Thread-0，a set num over--a
 * Thread-1，b set num over--b
 * name = b,num = 60
 * name = a,num = 50
 * 说明两个线程同时进入该方法
 * 原因：两个线程是不同的两个对象调用printNum()方法，synchronized修饰方法，每个对象都有一个锁，互不影响
 */
public class MultiThread {
    private int num = 0;

    public synchronized  void printNum(String name){
        try{
            if("a".equals(name)){
                num = 50;
                System.out.println(Thread.currentThread().getName()+"，a set num over--"+name);
                Thread.sleep(1000);
            }else{
                num = 60;
                System.out.println(Thread.currentThread().getName()+"，b set num over--"+name);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("name = " + name + ",num = " + num);

    }

    public static void main(String[] args) {
        final MultiThread multiThread = new MultiThread();
        final MultiThread multiThread2 = new MultiThread();
        Thread t1 = new Thread() {
            @Override
            public void run(){
                multiThread.printNum("a");
            }

        };
        Thread t2 = new Thread() {
            @Override
            public void run(){
                multiThread2.printNum("b");
            }
        };
        t1.start();
        t2.start();
    }
}
