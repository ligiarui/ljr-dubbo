package cn.ligiarui.bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description:
 * @author: lijiarui
 * @create: 2018-11-01 10:05
 **/
public class SocketClient {

    private static int PORT = 7777;

    private static String IP = "127.0.0.1";

    private static int i = 0;

    public static void send(){
        Socket socket = null;
        PrintWriter out = null;
        try{
            i++;
            socket = new Socket(IP,PORT);
            System.out.println("客户端第"+i+"次发送请求");
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("请求"+i);
        } catch (IOException e){
            e.getLocalizedMessage();
        } finally {
            if(out != null){
                out.close();
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
