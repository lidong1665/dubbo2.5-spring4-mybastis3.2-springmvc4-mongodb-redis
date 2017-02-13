package com.lidong.dubbo.web.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @项目名称:lidong-dubbo
 * @类名:RestApiConfig
 * @类的描述: Restapi的基本配置
 * @作者:lidong
 * @创建时间:2017/2/11 上午10:01
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 * @使用方法：Restful API 访问路径: http://localhost:8080/lidong-dubbo-web/swagger-ui.html
 */
@EnableWebMvc
@EnableSwagger2
@Configuration
@ComponentScan(basePackages ="com.lidong.dubbo")
public class RestApiConfig extends WebMvcConfigurationSupport {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lidong.dubbo.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringMVC中使用Swagger2构建RESTful APIs")
                .termsOfServiceUrl("https://github.com/lidong1665")
                .contact(new Contact("请叫我小东子","http://blog.csdn.net/u010046908","lidong1665@163.com"))
                .version("1.0.0")
                .build();
    }

}
