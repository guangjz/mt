package com.qa.testPJ;

/**
 * Created by guangjiazheng on 2018/12/6.
 */
import sohuadx.WriteLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        byte[] buf = new byte[1048576];
        InputStream in = null;

        try {
            in = this.socket.getInputStream();
            int e = in.read(buf, 0, 1048576);
            String dataString = new String(buf, 0, e);
            String resource = URLDecoder.decode(dataString, "UTF-8");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(new Date()));
            System.out.println(resource);
            WriteLog.writeIntoFile(df.format(new Date()) + " :" + resource, ".//src//callback.txt", true);
            PrintStream writer = new PrintStream(this.socket.getOutputStream(), true);
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-type:text/html");
            writer.println();
            writer.print("{code:0}");
            writer.flush();
        } catch (Exception var20) {
            var20.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException var19) {
                    var19.printStackTrace();
                }
            }

            if(this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException var18) {
                    var18.printStackTrace();
                }
            }

        }

    }
}
