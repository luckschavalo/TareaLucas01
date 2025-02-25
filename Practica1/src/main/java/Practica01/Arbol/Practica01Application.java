package Practica01.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Practica01Application {
    private static final Logger logger = LoggerFactory.getLogger(Practica01Application.class);
    
    public static void main(String[] args) {
        SpringApplication.run(Practica01Application.class, args);
        logger.trace("Aplicación iniciada correctamente.");
    }
}

@Configuration
class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/tu_base_de_datos")
                .username("tu_usuario")
                .password("tu_contraseña")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
