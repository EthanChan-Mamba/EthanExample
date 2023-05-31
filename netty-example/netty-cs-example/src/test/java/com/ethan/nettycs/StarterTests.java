package com.ethan.nettycs;

import com.ethan.nettycs.client.Client;
import com.ethan.nettycs.server.Server;
import org.junit.jupiter.api.Test;

/**
 * @ClassName StarterTests.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-31 10:44
 */
public class StarterTests {
    static int port = 9011;

    @Test
    public void startServer(){
        Server server = new Server(9011);
    }

    @Test
    public void startClient(){
        Client client = new Client(port);
        client.send("Hello Netty!");
        while (true){}
    }
}
