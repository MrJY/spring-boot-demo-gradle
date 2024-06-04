package mrjy.online.springboot.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 为所有路径启用跨域
                .allowedMethods("*") // 允许所有HTTP方法
                .allowedHeaders("*") // 允许所有头部
                .allowCredentials(false); // 允许携带Cookie
    }
}
