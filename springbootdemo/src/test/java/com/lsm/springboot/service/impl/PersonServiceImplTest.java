package com.lsm.springboot.service.impl;

import com.lsm.springboot.BaseTest;
import com.lsm.springboot.service.IPersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by shenming.li on 2017/6/13.
 */
public class PersonServiceImplTest extends BaseTest {
    @Autowired
    private IPersonService personServiceImpl;

    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException{

        personServiceImpl.transactionTestFailure();
    }
}
