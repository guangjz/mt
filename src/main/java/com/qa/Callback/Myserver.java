package com.qa.Callback;

import com.qa.testPJ.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by guangjiazheng on 2018/12/14.
 */
public class Myserver {

    public Myserver() {
    }

    public static void main(String[] args) throws IOException, Exception {
        ServerSocket svrSocket = new ServerSocket(10001);
        Socket socket = null;
        int count = 0;

        while(true) {
            socket = svrSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
            ++count;
            System.out.println("数量: " + count);
        }
    }
}
