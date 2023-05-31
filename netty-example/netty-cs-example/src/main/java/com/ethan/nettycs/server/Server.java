package com.ethan.nettycs.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Server.java
 * @Description TODO
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-05-31 10:29
 */
@Slf4j
public class Server {

    private EventLoopGroup boosGroup;

    private EventLoopGroup workGroup;

    public Server(int port){
        try {
            init(port);
            log.info("----- 服务启动成功 -----");
        } catch (InterruptedException e) {
            log.error("启动服务出错：{}", e.getCause());
        }
    }

    private void init(int port) throws InterruptedException {
        // 处理连接
        this.boosGroup = new NioEventLoopGroup();
        // 处理业务
        this.workGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        // 绑定
        bootstrap.group(boosGroup, workGroup)
                .channel(NioServerSocketChannel.class) //配置服务端
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_RCVBUF, 1024)
                .childOption(ChannelOption.SO_SNDBUF, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ServerHandler());
                    }
                });

        ChannelFuture channelFuture = bootstrap.bind(port).sync();
        channelFuture.channel().closeFuture().sync();
    }

    public void close(){
        this.boosGroup.shutdownGracefully();
        this.workGroup.shutdownGracefully();
    }

}
