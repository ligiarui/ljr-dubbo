package cn.ligiarui.socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: lijiarui
 * @create: 2018-11-01 11:14
 **/
public class SocketTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();

        //运行服务器
        new Thread(() -> SocketServer.accept()).start();

        //防止客户端先于服务器启动前执行代码
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->{
            while (true) {
                SocketClient.send();
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
