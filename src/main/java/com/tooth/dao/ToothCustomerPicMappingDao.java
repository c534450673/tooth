package com.tooth.dao;

import com.tooth.entity.ToothCustomerPicMapping;

public interface ToothCustomerPicMappingDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothCustomerPicMapping record);

    int insertSelective(ToothCustomerPicMapping record);

    ToothCustomerPicMapping selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothCustomerPicMapping record);

    int updateByPrimaryKey(ToothCustomerPicMapping record);
}