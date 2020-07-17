package com.tooth.constants;

/**
 * Created by wxu2 on 2017/6/12.
 */
public enum Message {

    /**
     * 成功
     */
    SUCCESS("Success"),

    /**
     * 请求失败
     */
    FAILED("Request failed"),

    /**
     * ssoId不存在
     */
    SSO_NOT_FOUND("用户不存在！"),

    /**
     * system error
     */
    SYSTEM_ERROR("系统错误！"),

    PARAMS_VALIDATION_FAILED("参数验证错误！")
    ;

    private String value;

    private Message(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
