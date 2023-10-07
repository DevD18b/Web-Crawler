package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class webServerInJava
{
    public static void main(String[] args) throws Exception {
        try(ServerSocket serverSocket = new ServerSocket(8040);) {
            System.out.println("Server started...");
            while(true){
                try(Socket client = serverSocket.accept()){
                    InputStreamReader isr = new InputStreamReader(client.getInputStream());
                    BufferedReader bfr = new BufferedReader(isr);
                    StringBuilder request = new StringBuilder("");
                    String line ;
                    line = bfr.readLine();
                    while(!line.isBlank()){
                        request.append(line).append("\r\n");
                        line  = bfr.readLine();
                    }
                   // System.out.println(request + " ");
                    OutputStream ops = client.getOutputStream();
                    ops.write(("HTTPS/1.1 200 OK\r\n").getBytes());
                    ops.write(("\r\n").getBytes(StandardCharsets.UTF_8));
                    ops.write(("hi world").getBytes(StandardCharsets.UTF_8));
                }
            }
        }
    }
}
