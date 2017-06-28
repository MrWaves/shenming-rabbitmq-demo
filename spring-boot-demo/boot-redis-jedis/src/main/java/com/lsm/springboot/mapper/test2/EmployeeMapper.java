package com.lsm.springboot.mapper.test2;

import com.lsm.springboot.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    int insert(Employee employee);

    Employee selectByPrimaryKey(@Param("id") Long id);

    List<Employee> selectByPhoneNum(@Param("phoneNum") Long phoneNum);

}