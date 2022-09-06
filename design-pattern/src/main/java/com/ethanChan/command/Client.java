package com.ethanChan.command;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-15 20:13
 */
public class Client {
    public static void main(String[] args) {
        // 创建电灯的对象（接受者）
        LightReceiver lightReceiver = new LightReceiver();

        // 创建电灯相关开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        // 创建遥控器
        RemoteCommand remoteCommand = new RemoteCommand();

        // 给遥控器设置命令
        remoteCommand.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("开电灯");
        remoteCommand.onButtonWasPushed(0);
        System.out.println("关电灯");
        remoteCommand.offButtonWasPushed(0);
        System.out.println("撤销");
        remoteCommand.undoButtonWasPushed();
    }
}
