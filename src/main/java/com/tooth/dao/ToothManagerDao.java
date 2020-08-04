package com.tooth.dao;

import com.tooth.entity.ToothManager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToothManagerDao {
    int deleteByPrimaryKey(String soeId);

    int insert(ToothManager record);

    int insertSelective(ToothManager record);

    ToothManager selectByPrimaryKey(String soeId);

    int updateByPrimaryKeySelective(ToothManager record);

    int updateByPrimaryKey(ToothManager record);

    /**
     * 功能描述 查询管理员
     * @author subo.zhang
     * @date 2020/8/4
      * @param toothManager
     * @return com.tooth.entity.ToothManager
     * @company own
    */
    ToothManager findToothManager(ToothManager toothManager);
    
}