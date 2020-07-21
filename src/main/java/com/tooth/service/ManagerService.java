package com.tooth.service;

import com.tooth.api.vo.ManagerInfo;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {

    /**
     * 功能描述 注册用户
     * @author subo.zhang
     * @date 2020/7/17
      * @param managerInfo
     * @return java.lang.Boolean
     * @company own
    */
    Boolean registerManager(ManagerInfo managerInfo);

}
