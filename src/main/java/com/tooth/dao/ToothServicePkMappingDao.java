package com.tooth.dao;

import com.tooth.entity.ToothServicePkMapping;

public interface ToothServicePkMappingDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothServicePkMapping record);

    int insertSelective(ToothServicePkMapping record);

    ToothServicePkMapping selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothServicePkMapping record);

    int updateByPrimaryKey(ToothServicePkMapping record);
}