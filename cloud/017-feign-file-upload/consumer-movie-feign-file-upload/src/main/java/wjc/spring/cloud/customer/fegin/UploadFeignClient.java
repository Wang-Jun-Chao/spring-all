package wjc.spring.cloud.customer.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import wjc.spring.cloud.customer.config.MultipartSupportConfig;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-01-03 16:25
 **/
@FeignClient(name = "feign-file-upload", configuration = MultipartSupportConfig.class)
public interface UploadFeignClient {

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart("file")MultipartFile file);
}
