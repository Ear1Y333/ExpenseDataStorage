package mySpring.ExpenseDataSrorage.Core;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerDocumentation {
    private static final String TITLE = "Expense data storage documentation";
    private static final String URL = "http://localhost:8080";
    @Bean
    public OpenAPI api() {
        return new OpenAPI().
            servers(List.of(new Server()
                .url(URL)))
                .info(new Info()
                .title(TITLE));
    }
}