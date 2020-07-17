package com.tooth.dao;

import com.tooth.entity.ToothCustomer;

public interface ToothCustomerDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothCustomer record);

    int insertSelective(ToothCustomer record);

    ToothCustomer selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothCustomer record);

    int updateByPrimaryKey(ToothCustomer record);
}