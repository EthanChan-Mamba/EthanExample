package com.ethanChan.command;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName NoCommand.java
 * @Description 空命令，初始化每个按钮; 是一种设计模式，可以省略空判断
 * @createTime 2022-05-15 20:02
 */
public class NoCommand implements Command {
    public void execute() {

    }

    public void undo() {

    }
}
