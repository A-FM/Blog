package pers.ycy.blog.controller.v1;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Test;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * @author: 袁重阳
 * @description: 文件上传接口
 * @create: 2019-11-29 17:16
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-11-29 17:16
 */
@RestController
@RequestMapping(value = "file")
public class UploadFile {


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(MultipartFile multipartFile, String bucket) {
        OSS ossClient = null;
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("aliyunOSS.properties");
            String endpoint = properties.getProperty("endpoint");
            String accessKeyId = properties.getProperty("accessKeyId");
            String accessKeySecret = properties.getProperty("accessKeySecret");
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            assert multipartFile.getOriginalFilename() != null;
            String fileName = new Date().getTime() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));

            ossClient.putObject(bucket, fileName, multipartFile.getInputStream());

            return "https://" + bucket + "." + endpoint + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }
}
