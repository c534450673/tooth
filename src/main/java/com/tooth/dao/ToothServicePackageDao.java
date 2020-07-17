package com.tooth.dao;

import com.tooth.entity.ToothServicePackage;

public interface ToothServicePackageDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothServicePackage record);

    int insertSelective(ToothServicePackage record);

    ToothServicePackage selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothServicePackage record);

    int updateByPrimaryKey(ToothServicePackage record);
}