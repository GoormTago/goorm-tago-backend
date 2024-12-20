package io.goormtago;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures Cross-Origin Resource Sharing (CORS) settings.
     * @param registry The CorsRegistry to configure.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Allow all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific HTTP methods
                .allowedHeaders("*") // Allow all headers
                .maxAge(3600); // Cache preflight requests for 1 hour
    }

    /**
     * Adds custom formatters to handle date parsing and printing.
     * @param registry The FormatterRegistry to configure.
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<LocalDate>() {
            private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public LocalDate parse(String text, Locale locale) {
                try {
                    return LocalDate.parse(text, dateFormatter);
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Invalid date format. Please use 'yyyy-MM-dd'.", e);
                }
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                return dateFormatter.format(object);
            }
        });
    }
}
