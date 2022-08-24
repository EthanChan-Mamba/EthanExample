package com.ethanChan.command;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName RemoteCommand.java
 * @Description TODO
 * @createTime 2022-05-15 20:05
 */
public class RemoteCommand {
    // 开、关按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;

    // 执行撤销命令
    Command undoCommand;

    // 构造器，执行对按钮初始化
    public RemoteCommand() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    // 给按钮设置需要的命令
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = onCommand;
    }

    // 按下开按钮
    public void onButtonWasPushed(int no) {
        // 找到按下的开按钮，并执行
        onCommands[no].execute();
        // 记录操作，用于撤销
        undoCommand = onCommands[no];
    }

    // 按下关按钮
    public void offButtonWasPushed(int no) {
        offCommands[no].execute();
        undoCommand = offCommands[no];
    }

    // 撤销
    public void undoButtonWasPushed() {
        undoCommand.execute();
    }

}
