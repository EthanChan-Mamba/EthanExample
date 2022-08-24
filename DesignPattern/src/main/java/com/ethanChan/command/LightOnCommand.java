package com.ethanChan.command;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName LightOnCommand.java
 * @Description TODO
 * @createTime 2022-05-15 19:58
 */
public class LightOnCommand implements Command {

    // 聚合LightReceiver
    LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    public void execute() {
        // 调用接收者的方法
        lightReceiver.on();
    }

    public void undo() {
        lightReceiver.off();
    }
}
