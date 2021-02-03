package com.udacity.jdnd.course3.Config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource getDataSource (DataSourceProperties properties){
        DataSourceBuilder dsb = DataSourceBuilder.create();
        dsb.username("admin");
        dsb.password(securePasswordService());
        dsb.url("jdbc:mysql://localhost:3306/plant");
        return dsb.build();
    }

    private String securePasswordService() {
        return "admin12345";
    }
}
