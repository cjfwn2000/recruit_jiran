package com.leecheolju.mydemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    // 스프링의 설정을 담당하는 클래스

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 음성파일을 웹페이지에 보여줄 수 있도록 외부 디렉토리를 따로 둔다.
        // 음성파일은 파이썬 스크립트를 통해 새로이 생성되는 것이므로 static하지 못하다.
        registry
            .addResourceHandler("/ttsfile/**")
            .addResourceLocations("file:python-tts/");

    }
}
