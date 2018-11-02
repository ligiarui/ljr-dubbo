package cn.ligiarui.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @description:
 * @author: lijiarui
 * @create: 2018-11-01 10:08
 **/
public class SocketHandler implements Runnable {

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    private Socket socket;

    @Override
    public void run() {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg =reader.readLine()) != null) {
                System.out.println("服务端接收到数据:" + msg);
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }
}
