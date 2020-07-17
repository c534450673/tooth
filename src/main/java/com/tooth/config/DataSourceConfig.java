package com.tooth.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author subo.zhang
 * @date 2018年12月06日
 * @company own
 **/
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.tooth")
    @Primary
    public DataSourceProperties toothDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Primary
    public HikariDataSource toothDataSource() {
        DataSourceProperties dataSourceProperties = toothDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @MapperScan(basePackages = "com.tooth.dao", sqlSessionFactoryRef = "toothSqlSessionFactory")
    @Configuration
    @DependsOn("toothDataSource")
    class toothDataSourceConfig {

        @Value("${mybatis.mapper-locations.tooth}")
        private String mapperLocations;

        @Bean
        public SqlSessionFactory toothSqlSessionFactory(@Qualifier("toothDataSource") DataSource toothDataSource) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(toothDataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
            return factoryBean.getObject();
        }

        @Bean
        public PlatformTransactionManager toothTransactionManager(@Qualifier("toothDataSource") DataSource toothDataSource) {
            return new DataSourceTransactionManager(toothDataSource);
        }
    }

}
