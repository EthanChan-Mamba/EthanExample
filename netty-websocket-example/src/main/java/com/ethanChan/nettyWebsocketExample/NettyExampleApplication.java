package com.ethanChan.nettyWebsocketExample;

import com.ethanChan.nettyWebsocketExample.config.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName com.chen.nettyExample.NettyExampleApplication.java
 * @Description TODO
 * @createTime 2022-08-19 09:45
 */
@SpringBootApplication
public class NettyExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyExampleApplication.class, args);
        try {
            new NettyServer(12345).start();
            System.out.println("https://blog.csdn.net/moshowgame");
            System.out.println("http://127.0.0.1:6688/netty-websocket/index");
        }catch(Exception e) {
            System.out.println("NettyServerError:"+e.getMessage());
        }
    }
}
