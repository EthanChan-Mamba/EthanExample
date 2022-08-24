package com.chen.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-22 11:53
 */
public class Client {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<College>();
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        colleges.add(computerCollege);
        colleges.add(infoCollege);

        OutPutImpl outPut = new OutPutImpl(colleges);
        outPut.printCollege();
    }
}
