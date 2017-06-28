package com.lsm.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lsm.springboot.constant.TransactionalManagerConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

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

    @Value("${datasource.test.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;

    @Bean(name = DATA_SOURCE_DATA)
    @Primary
    public DataSource testDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(15);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(280); // sec
        dataSource.setMaxWait(30000);
        dataSource.setValidationQuery("SELECT 1 FROM DUAL");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

    @Bean(name = SQL_SESSION_FACTORY_DATA)
    @Primary
    public SqlSessionFactory sqlSessionFactoryBeanData(@Qualifier(DATA_SOURCE_DATA) DataSource testSource) {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(testSource);
            // 当xml文件和mapper不在一起的时候
            Resource[] mapperResources = new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/test/*.xml");
            sessionFactory.setMapperLocations(mapperResources);
            /*sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:config/mybatis/mybatis-config.xml"));*/
            return sessionFactory.getObject();
        } catch (Exception e) {
            logger.error("faile to create data sql session", e);
            throw new RuntimeException(e);
        }
    }

    @Bean(name = TransactionalManagerConstant.TEST_DATASOURCE_TRANSACTIONAL_MANAGER_NAME)
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier(DATA_SOURCE_DATA) DataSource testSource) {

        return new DataSourceTransactionManager(testSource);
    }

}
