package com.lsm.springboot.constant;

/**
 * Created by shenming.li on 2017/6/14.
 * 各个数据源的事务manager name
 */
public class TransactionalManagerConstant {

    public static final String TEST_DATASOURCE_TRANSACTIONAL_MANAGER_NAME = "testTxManager";

    public static final String TEST2_DATASOURCE_TRANSACTIONAL_MANAGER_NAME = "test2TxManager";

    public static final String SHARDING_DATASOURCE_TRANSACTIONAL_MANAGER_NAME = "shardingTransactionManager";
}
