package ls.org.rsl.agecalculator.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Config {
    @Value("${cors.origin}")
    private String corsOrigin;
    @Value("${cors.allowed-method}")
    private String allowedMethods;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {

                logger.info("\nAllowed CORS methods: {}\nAllowed CORS origin: {}",allowedMethods, corsOrigin);
                registry.addMapping("/**")
                        .allowedMethods(allowedMethods)
                        .allowedOrigins(corsOrigin);
            }
        };
    }
}
