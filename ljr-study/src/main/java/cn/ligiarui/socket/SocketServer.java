package cn.ligiarui.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: lijiarui
 * @create: 2018-11-01 10:06
 **/
public class SocketServer {

    private static ServerSocket serverSocket;

    public SocketServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public static void accept(){
        Socket socket = null;
            try{
                serverSocket = new ServerSocket(7777);
                System.out.println("服务端已启动，端口号:" + 7777);
                while(true){
                socket = serverSocket.accept();
                Thread t = new Thread(new SocketHandler(socket));
                t.start();
                }
            } catch (IOException e) {
                e.getLocalizedMessage();
            } finally {
                try {
                    if(socket != null){
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
