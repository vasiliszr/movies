package com.aueb.movies.config;

import com.aueb.movies.dao.UsersDAO;
import com.aueb.movies.dao.UsersDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.aueb.movies")
public class SpringMVCConfig implements WebMvcConfigurer {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433/movies"); //"jdbc:sqlserver://LAPTOP-CFSVBPA4"
        dataSource.setUsername("sa");
        dataSource.setPassword("vasilis19700");
        return  dataSource;
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".html");
        return resolver;
    }

    @Bean
    public UsersDAO getUsersDAO() {
        return new UsersDAOImpl(getDataSource());
    }

}
