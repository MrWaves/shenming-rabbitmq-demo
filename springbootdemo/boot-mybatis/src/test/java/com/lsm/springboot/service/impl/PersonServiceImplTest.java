package com.lsm.springboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsm.springboot.BaseTest;
import com.lsm.springboot.constant.TransactionalManagerConstant;
import com.lsm.springboot.domain.Person;
import com.lsm.springboot.service.IPersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by shenming.li on 2017/6/13.
 */
public class PersonServiceImplTest extends BaseTest {
    @Autowired
    private IPersonService personServiceImpl;

    @Test()
    public void testInsert(){
        Person person = new Person();
        person.setName("llllll");
        personServiceImpl.insert(person);

    }

    @Test
    public void testSelectAll() {
        PageHelper.startPage(2, 10);
        List<Person> personList = personServiceImpl.selectAll();
        PageInfo<Person> pageInfo = new PageInfo(personList);
        Page page = (Page) personList;

        System.out.println("PageInfo: " + pageInfo + ", Page: " + page );
    }
}
