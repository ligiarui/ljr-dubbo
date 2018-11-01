package cn.ligiarui.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @author: lijiarui
 * @create: 2018-11-01 10:05
 **/
public class SocketClient {

    private int PORT = 7777;

    private String IP = "127.0.0.1";

    public void send(){
        try{
            Socket socket = new Socket(IP,PORT);
        } catch (IOException e){
            e.getLocalizedMessage();
        }

    }
}
