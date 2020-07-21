package com.tooth.dao;

import com.tooth.entity.ToothManager;

public interface ToothManagerDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothManager record);

    int insertSelective(ToothManager record);

    ToothManager selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothManager record);

    int updateByPrimaryKey(ToothManager record);
    
}