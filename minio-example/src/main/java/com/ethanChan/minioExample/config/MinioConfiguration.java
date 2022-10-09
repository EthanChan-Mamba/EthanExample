package com.ethanChan.minioExample.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName MinioConfiguration.java
 * @Description TODO
 * @createTime 2022-10-09 10:34
 */
@Configuration
@ConfigurationProperties(prefix = "spring.minio")
@Data
public class MinioConfiguration {
    private String accessKey;

    private String secretKey;

    private String url;

    private String bucketName;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }
}
