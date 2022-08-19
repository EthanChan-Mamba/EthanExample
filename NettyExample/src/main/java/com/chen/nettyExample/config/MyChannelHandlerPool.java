package com.chen.nettyExample.config;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName MyChannelHandlerPool.java
 * @Description 通道组池，管理所有websocket连接
 * @createTime 2022-08-19 09:51
 */
public class MyChannelHandlerPool {

    public MyChannelHandlerPool(){}

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
