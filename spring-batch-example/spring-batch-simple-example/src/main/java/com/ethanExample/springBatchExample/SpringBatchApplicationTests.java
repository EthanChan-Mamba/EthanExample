package com.ethanExample.springBatchExample;

import static org.assertj.core.api.Assertions.assertThat;

import com.ethanExample.springBatchExample.config.BatchConfig;
import com.ethanExample.springBatchExample.config.HelloWorldJobConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.batch.operations.NoSuchJobException;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SpringBatchApplicationTests.java
 * @Description TODO
 * @createTime 2022-09-08 11:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {SpringBatchApplicationTests.BatchTestConfig.class})
public class SpringBatchApplicationTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testHelloWorldJob() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertThat(jobExecution.getExitStatus().getExitCode())
                .isEqualTo("COMPLETED");
    }

    @Configuration
    @Import({BatchConfig.class, HelloWorldJobConfig.class})
    static class BatchTestConfig {

        @Autowired
        private Job helloWorlJob;

        @Bean
        JobLauncherTestUtils jobLauncherTestUtils()
                throws NoSuchJobException {
            JobLauncherTestUtils jobLauncherTestUtils =
                    new JobLauncherTestUtils();
            jobLauncherTestUtils.setJob(helloWorlJob);

            return jobLauncherTestUtils;
        }
    }
}
