package cn.ligiarui.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description:
 * @author: lijiarui
 * @create: 2018-11-08 16:40
 **/
public class FileNio {

    public static void main(String[] args) {
        FileOutputStream out =null;
        FileInputStream in =null;
        try {
            File file = new File("d://aaa.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            out = new FileOutputStream(file);
            FileChannel outChannel = out.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(32);
            buf.put("我是测试哈哈哈哈abcdefg".getBytes("UTF-8"));
            while(buf.hasRemaining()){
                buf.flip();
                outChannel.write(buf);
            }
            outChannel.close();
            buf.clear();

//            in = new FileInputStream(file);
//            FileChannel inChannel = in.getChannel();
            //获取fileChannel的不同方式
            Path path = Paths.get("d://aaa.txt");
            FileChannel inChannel = FileChannel.open(path);
            //一个汉字3个字节
            ByteBuffer buf1 = ByteBuffer.allocate(3);
            Charset utf8 = Charset.forName("UTF-8");
            while (inChannel.read(buf1) != -1) {
                buf1.flip();
                CharBuffer cb = utf8.decode(buf1);
                System.out.println("循环读取:" + cb.toString());
                buf1.clear();
            }
            inChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
