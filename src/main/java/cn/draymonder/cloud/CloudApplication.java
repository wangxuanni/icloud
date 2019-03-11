package cn.draymonder.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
//@SpringBootApplication(scanBasePackages = {"cn.draymonder.cloud.service.impl","cn.draymonder.cloud.controller"})
//@MapperScan(basePackages = {"cn.draymonder.cloud.dao"})
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

//    @Bean(name = "multipartResolver")
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//        resolver.setMaxInMemorySize(40960);
//        resolver.setMaxUploadSize(10 * 1024 * 1024);//上传文件大小 5M 5*1024*1024
//        return resolver;
//    }
}
