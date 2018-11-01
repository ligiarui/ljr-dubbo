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

    private ServerSocket serverSocket;

    public SocketServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void accept(){
        while(true){
            try{
                Socket socket = serverSocket.accept();
                Thread t = new Thread(new SocketHandler(socket));
                t.start();
            } catch (IOException e) {
                e.getLocalizedMessage();
            }

        }
    }
}
