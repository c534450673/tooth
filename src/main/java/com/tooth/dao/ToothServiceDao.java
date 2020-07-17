package com.tooth.dao;

import com.tooth.entity.ToothService;

public interface ToothServiceDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothService record);

    int insertSelective(ToothService record);

    ToothService selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothService record);

    int updateByPrimaryKey(ToothService record);
}