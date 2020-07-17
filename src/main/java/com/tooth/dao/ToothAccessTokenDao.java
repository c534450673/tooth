package com.tooth.dao;

import com.tooth.entity.ToothAccessToken;

public interface ToothAccessTokenDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ToothAccessToken record);

    int insertSelective(ToothAccessToken record);

    ToothAccessToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToothAccessToken record);

    int updateByPrimaryKey(ToothAccessToken record);
}