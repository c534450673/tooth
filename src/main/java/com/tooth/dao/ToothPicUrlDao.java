package com.tooth.dao;

import com.tooth.entity.ToothPicUrl;

public interface ToothPicUrlDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothPicUrl record);

    int insertSelective(ToothPicUrl record);

    ToothPicUrl selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothPicUrl record);

    int updateByPrimaryKey(ToothPicUrl record);
}