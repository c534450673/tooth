package com.tooth.service.impl;

import com.tooth.api.vo.ManagerInfo;
import com.tooth.constants.Code;
import com.tooth.constants.SubCode;
import com.tooth.dao.ToothManagerDao;
import com.tooth.entity.ToothManager;
import com.tooth.exception.BaseException;
import com.tooth.service.ManagerService;
import com.tooth.utils.Md5PasswdUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ToothManagerDao toothManagerDao;

    @Override
    public Boolean registerManager(ManagerInfo managerInfo) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        validateParam(managerInfo);
        // 密码加密
        String passwd = Md5PasswdUtils.encoderByMd5(managerInfo.getPasswd());
        ToothManager toothManager = managerInfo.converToDbEntity();
        toothManager.setPasswd(passwd);
        int insert = toothManagerDao.insert(toothManager);
        return insert > 0;
    }

    /**
     * 功能描述 验证用户参数
     * @author subo.zhang
     * @date 2020/8/4
      * @param managerInfo
     * @return void
     * @company own
    */
    private void validateParam(ManagerInfo managerInfo){
        boolean validatePhoneAndEmail = managerInfo.validatePhoneAndEmail();
        if(!validatePhoneAndEmail) {
            throw new BaseException(Code.BUSINESS_EXCEPTIONS.value(), SubCode.REQUIRED_EMAIL_OR_PHONE.value(), "请输入邮箱或者手机号！");
        }
        ToothManager findToothManager;
        // 根据用户名进行查询
        findToothManager = toothManagerDao.findToothManager(ToothManager.builder().userName(managerInfo.getUserName()).build());
        if(findToothManager != null){
            throw new BaseException(Code.PARAM_VALIDATE_FAILED.value(), SubCode.REPEAT_PARAM.value(), "用户名已存在！");
        }
        if(StringUtils.isNotBlank(managerInfo.getPhoneNum())){
            findToothManager = toothManagerDao.findToothManager(ToothManager.builder().phoneNum(managerInfo.getPhoneNum()).build());
            if(findToothManager != null){
                throw new BaseException(Code.PARAM_VALIDATE_FAILED.value(), SubCode.REPEAT_PARAM.value(), "手机号已存在！");
            }
        }
        if(StringUtils.isNotBlank(managerInfo.getEmail())){
            findToothManager = toothManagerDao.findToothManager(ToothManager.builder().email(managerInfo.getEmail()).build());
            if(findToothManager != null){
                throw new BaseException(Code.PARAM_VALIDATE_FAILED.value(), SubCode.REPEAT_PARAM.value(), "邮箱已存在！");
            }
        }
    }
}
