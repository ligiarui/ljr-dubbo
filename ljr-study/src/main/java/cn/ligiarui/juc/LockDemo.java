package cn.ligiarui.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: lijiarui
 * @create: 2018-12-29 13:57
 **/
public class LockDemo implements Runnable{

    static Lock lock = new ReentrantLock();

    static  int i = 0;

    public static void main(String[] args) {
            for(int i =0;i<1000;i++){
                Thread t = new Thread(new LockDemo());
                t.start();
            }
    }

    @Override
    public void run() {
        lock.lock();
        i++;
        lock.unlock();
        System.out.println(Thread.currentThread().getName()+ "========i:" + i);
    }
}
