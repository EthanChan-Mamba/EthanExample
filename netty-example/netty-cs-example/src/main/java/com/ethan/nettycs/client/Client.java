package com.ethan.nettycs.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Client.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-31 10:43
 */
@Slf4j
public class Client {

    private EventLoopGroup workGroup;
    private ChannelFuture channelFuture;

    public Client(int port){
        init(port);
    }

    private void init(int port){
        this.workGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .option(ChannelOption.SO_RCVBUF, 1024)
                .option(ChannelOption.SO_SNDBUF, 1024)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ClientHandler());
                    }
                });

        this.channelFuture = bootstrap.connect("127.0.0.1", port).syncUninterruptibly();
    }

    /**
     *
     * @param message
     */
    public void send(String message){
        this.channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(message.getBytes()));
    }

    /**
     *
     */
    public void close(){
        try {
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        workGroup.shutdownGracefully();
    }
}
