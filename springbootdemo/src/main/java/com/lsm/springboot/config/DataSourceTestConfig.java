package com.lsm.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by lishenming on 2017/4/19.
 */
@Configuration
@MapperScan(basePackages = DataSourceTestConfig.DATA_PACKAGE, sqlSessionFactoryRef = DataSourceTestConfig.SQL_SESSION_FACTORY_DATA)
public class DataSourceTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceTestConfig.class);
    static final String DATA_PACKAGE = "com.lsm.springboot.mapper.test";
    static final String SQL_SESSION_FACTORY_DATA = "sqlSessionFactoryData";

    private static final String DATA_SOURCE_DATA = "testDataSource";
    private static final String TX_MANAGER_DATA = "testTxManager";

    @Value("${datasource.test.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;

    @Bean(name = DATA_SOURCE_DATA)
    @Primary
    public DataSource testDataSource() {
        return DataSourceConfig.createBasicDataSource(url, username, password);
    }

    @Bean(name = SQL_SESSION_FACTORY_DATA)
    @Primary
    public SqlSessionFactory sqlSessionFactoryBeanData(@Qualifier(DATA_SOURCE_DATA) DataSource testSource) {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(testSource);
            // 当xml文件和mapper不在一起的时候
          /*  Resource[] mapperResources = new PathMatchingResourcePatternResolver().getResources("classpath:config/mybatis/mapper/data*//*.xml");
            sessionFactory.setMapperLocations(mapperResources);*/
           /* sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:config/mybatis/mybatis-config.xml"));*/
            return sessionFactory.getObject();
        } catch (Exception e) {
            logger.error("faile to create data sql session", e);
            throw new RuntimeException(e);
        }
    }

    @Bean(name = TX_MANAGER_DATA)
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier(DATA_SOURCE_DATA) DataSource testSource) {

        return new DataSourceTransactionManager(testSource);
    }

}
