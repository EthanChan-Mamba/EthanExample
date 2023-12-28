package com.example.mavenplugin;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.Date;

@Mojo(name = "printDate")
public class PrintDatePlugin extends AbstractMojo {

    @Parameter(property = "name",defaultValue = "printDate")
    private String name;

    @Parameter(property = "description",defaultValue = "打印日期插件")
    private String description;

    @Parameter(property = "format",defaultValue = "yyyy-MM-dd HH:mm:ss")
    private String format;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Date date = new Date();
        Log log = getLog();
        log.info(StringUtils.repeat("=",20));
        log.info(String.format("开始执行插件：%s", name));
        log.info(String.format("插件信息：%s", description));
        log.info(String.format("执行插件：%s", DateFormatUtils.format(date,format)));
        log.info(StringUtils.repeat("=",20));
    }
}
