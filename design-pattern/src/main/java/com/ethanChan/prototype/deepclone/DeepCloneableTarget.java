package com.ethanChan.prototype.deepclone;

import java.io.Serializable;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName DeepCloneableTarget.java
 * @Description TODO
 * @createTime 2022-05-03 00:16
 */
public class DeepCloneableTarget implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
