package com.lsm.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lsm.springboot.constant.TransactionalManagerConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by lishenming on 2017/4/19.
 */
@Configuration
@MapperScan(basePackages = DataSourceTest2Config.DATA_PACKAGE, sqlSessionFactoryRef = DataSourceTest2Config.SQL_SESSION_FACTORY_DATA)
public class DataSourceTest2Config {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceTest2Config.class);
    static final String DATA_PACKAGE = "com.lsm.springboot.mapper.test2";
    static final String SQL_SESSION_FACTORY_DATA = "test2SqlSessionFactory";

    private static final String DATA_SOURCE_DATA = "test2DataSource";


    @Autowired
    private Environment env;

    @Bean(name = DATA_SOURCE_DATA)
    public DataSource test2DataSource() {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(env.getProperty("datasource.test2.url"));
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));
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
    public SqlSessionFactory sqlSessionFactoryBeanData(@Qualifier(DATA_SOURCE_DATA) DataSource test2Source) {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(test2Source);
            return sessionFactory.getObject();
        } catch (Exception e) {
            logger.error("faile to create data sql session", e);
            throw new RuntimeException(e);
        }
    }

    @Bean(name = TransactionalManagerConstant.TEST2_DATASOURCE_TRANSACTIONAL_MANAGER_NAME)
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier(DATA_SOURCE_DATA) DataSource testSource) {

        return new DataSourceTransactionManager(testSource);
    }

}
