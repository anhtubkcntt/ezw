package com.anvui.ezw.config;


import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@ConditionalOnProperty(value = "app.datasource.ezw.enable", havingValue = "true", matchIfMissing = true)
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "ezwEntityManagerFactory",
        transactionManagerRef = "ezwTransactionManager", basePackages = {"com.anvui.ezw.repository.jpa"})
public class EzwDatabaseConfig {

    @Value("${app.datasource.ezw.url:#{null}}")
    private String urlForLog;

    @Primary
    @Bean(name = "ezwDataSourceProperties")
    @ConfigurationProperties("app.datasource.ezw")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "ezwDataSource")
    @ConfigurationProperties(prefix = "app.datasource.ezw.configuration")
    public DataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "ezwPropertiesHibernate")
    @ConfigurationProperties(prefix = "app.datasource.ezw.properties")
    public Map<String, String> dataProperties() {
        return new HashMap<>();
    }

    @Primary
    @Bean(name = "ezwEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        log.info("DB config ezwDataSource: " + urlForLog);
        return builder.dataSource(dataSource()).properties(dataProperties()).packages("com.anvui.ezw.model.entity")
                .build();
    }

    @Primary
    @Bean(name = "ezwTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("ezwEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
