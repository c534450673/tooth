package com.tooth.dao;

import com.tooth.entity.ToothManagerServicePkMapping;

public interface ToothManagerServicePkMappingDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothManagerServicePkMapping record);

    int insertSelective(ToothManagerServicePkMapping record);

    ToothManagerServicePkMapping selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothManagerServicePkMapping record);

    int updateByPrimaryKey(ToothManagerServicePkMapping record);
}