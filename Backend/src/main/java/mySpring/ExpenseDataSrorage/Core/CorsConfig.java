package mySpring.ExpenseDataSrorage.Core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*") // Разрешает запросы из любого источника
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Разрешает использование любых HTTP-методов
                .allowedHeaders("*"); // Разрешает использование любых заголовков
    }
}