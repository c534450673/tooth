package com.tooth.service;

import com.tooth.api.vo.ManagerInfo;
import com.tooth.constants.Code;
import com.tooth.constants.SubCode;
import com.tooth.entity.ToothManager;
import com.tooth.exception.BaseException;
import org.springframework.beans.factory.annotation.Value;

public class ManagerServiceImpl implements ManagerService{
    @Value("{tooth.salt}")
    private String salt;

    @Override
    public Boolean registerManager(ManagerInfo managerInfo) {
        boolean validatePhoneAndEmail = managerInfo.validatePhoneAndEmail();
        if(!validatePhoneAndEmail){
            throw new BaseException(Code.BUSINESS_EXCEPTIONS.value(), SubCode.REQUIRED_EMAIL_OR_PHONE.value(), "请输入邮箱或者手机号！");
        }
        ToothManager toothManager = managerInfo.converToDbEntity();
        // 根据用户名进行查询


        return null;
    }
}
