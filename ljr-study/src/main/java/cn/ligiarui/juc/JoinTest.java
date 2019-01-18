package cn.ligiarui.juc;

/**
 * @description:
 * @author: lijiarui
 * @create: 2019-01-08 10:55
 **/
public class JoinTest{

    public static void main(String[] sure){
        Info t = new Info();
        t.aaa();
    }
}

class Info{
    public void aaa(){
        try {
            synchronized(this){
                wait();
            }
            //System.out.println("aaa");

            //System.out.println("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



