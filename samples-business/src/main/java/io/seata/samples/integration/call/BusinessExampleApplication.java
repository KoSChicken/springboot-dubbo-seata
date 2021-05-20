package io.seata.samples.integration.call;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.call")
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.call")
public class BusinessExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessExampleApplication.class, args);
    }

}

