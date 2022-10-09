package com.ethanChan.minioExample;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName MinioExampleApplication.java
 * @Description 使用MultipartFile接收前端文件流，再上传到minio。
 *      构建一个formData的签名数据，给前端，让前端之前上传到minio。
 *      构建一个可以上传的临时URL给前端，前端通过携带文件请求该URL进行上传。
 *      使用filename请求服务端获取临时访问文件的URL。（最长时间为7 天，想要永久性访问，需要其他设置，这里不做说明。）
 * @createTime 2022-10-08 11:39
 */
public class MinioExampleApplication {
}
