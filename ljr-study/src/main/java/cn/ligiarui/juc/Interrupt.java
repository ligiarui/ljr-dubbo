package cn.ligiarui.juc;

/**
 * https://blog.csdn.net/qq_32924343/article/details/79971109
 */
public class Interrupt extends Thread {

    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.start();
        System.out.println("main start");
        System.out.println("main state11:  " + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("main state22:  " + Thread.interrupted());
        System.out.println("main state33:  " + Thread.interrupted());
        System.out.println("main end");
    }
}
class T2 extends Thread {

    @Override
    public void run() {
        System.out.println("t2 into sleeping");
        try {
            Thread.sleep(20000);
            System.out.println("t2 wake up");
        } catch (InterruptedException e) {
            System.out.println("oh,shit! exception");
            return;
        }
        //System.out.println("oh,shit! exception");
    }

}