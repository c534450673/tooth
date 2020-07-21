package com.tooth.api.vo;

import com.tooth.entity.ToothManager;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;

@Data
public class ManagerInfo {
    @NotNull(message = "登录名不可为空！")
    private String userName;

    @NotNull(message = "姓名不可为空！")
    private String name;

    @NotNull(message = "密码不可为空！")
    private String passwd;

    private String phoneNum;

    private String email;

    private String status;

    /**
     * 功能描述 验证参数
     *
     * @param
     * @return boolean
     * @author subo.zhang
     * @date 2020/7/17
     * @company own
     */
    public boolean validatePhoneAndEmail() {
        if (StringUtils.isBlank(this.email) && StringUtils.isBlank(this.phoneNum)) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述 转化为数据库类型
     *
     * @param
     * @return com.tooth.entity.ToothManager
     * @author subo.zhang
     * @date 2020/7/17
     * @company own
     */
    public ToothManager converToDbEntity() {
        return ToothManager.builder().userName(this.userName).email(this.email).phoneNum(this.phoneNum).name(this.name).build();
    }
}
