package ec.com.eeasa.sisai.core.config.openApi;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SISAI")
                        .description("Sistema de arrendamientos de ductos y postes")
                        .version("v1.0"));
    }
}
