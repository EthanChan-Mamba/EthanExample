package com.chen.command;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Command.java
 * @Description 命令接口
 * @createTime 2022-05-15 19:57
 */
public interface Command {

    // 执行动作（操作）
    public void execute();
    // 撤销动作（操作）
    public void undo();
}
