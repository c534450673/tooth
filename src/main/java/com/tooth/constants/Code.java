package com.tooth.constants;

/**
 * Created by wxu2 on 2017/6/12.
 */
public enum Code {

    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 文件上传失败
     */
    FILE_UPLOAD_FAILED(416),
    /**
     * 执行失败
     */
    FAILED(417),
    /**
     * 票凭证验证失败
     */
    TICKET_FAILED(418),
    /**
     * 短信发送失败
     */
    MESSAGE_FAILED(419),
    /**
     * 参数验证失败
     */
    PARAM_VALIDATE_FAILED(400),
    /**
     * 权限验证失败
     */
    AUTHENTICATION_FAILED(401),
    /**
     *密码失败
     */
    PASSWORD_FAILED(402),
    /**
     * 非法客户端
     */
    INVALID_CLIENT(403),
    
    /**
     * 找不到资源
     */
    RESOURCE_NOT_FOUND(404),
    /**
     * 执行授权失败
     */
    AUTHORITY_FAILED(406),
    /**
     * 超级管理员
     */
     FILE_SUPER_ADMIN(407),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(500),
    /**
     * 判断是否是最新的版本
     */
    VERSIONS_EXISTED(428),
    /**
     * 请求获取微信的ticket失败
     */
    REQUEST_TICKET_FAIL(423),
    /**
     * 资源已经存在
     */
    RESOURCE_ALREADY_EXIST(421),
    /**
     * 用户被禁用
     */
    USER_WAS_FORBIDDEN(422),
    /**
     * 请求获取微信的openid失败
     */
    REQUEST_OPENID_FAIL(425),

    /**
     * 已经加入过排行榜了
     */
    JOINED_RANK(424),

    MISS_INDUSTRY_PARAM(426),
    /**
     * 判断orgid是否存在
     */
    ORGID_EXISTED(427),
    /**
     * 判断手机号码是否存在
     */
    ORGID_MOBILEPHONENUM(429),

    /**
     * 用户没有找到
     */
    USER_NOT_FOUND(420),

    /**
     * 证书申请失败
     */
    APPLY_CERTIFICATE_FAILED(430),

    /**
     * 不能重复申请证书
     */
    APPLY_CERTIFICATE_REPETITION(431),

    /**
     * 参数缺失或者不合法
     */
    PARAMMETERS_ARE_MISSING(432),

    /**
     * 其他错误，请联系法大大
     */
    OTHER_ERRORS(433),

    /**
     * 业务异常
     */
    BUSINESS_EXCEPTIONS(434),

    /**
     *
     */
    PARAMETER_VERIFY_FAILED(435)
    ;



    private Integer value;

    Code(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

}
