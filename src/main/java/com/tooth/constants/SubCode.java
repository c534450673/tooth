package com.tooth.constants;

/**
 * Created by wxu2 on 2017/6/12.
 */
public enum SubCode {

    PARAMETERS_FAILED("C400_8"),
    /**
     * 参数缺失
     */
    PARAMS_MISSING("C400_1"),

    /**
     * 参数非法
     */
    INVALID_PARAMS("C400_2"),

    /**
     * 参数名非法
     */
    INVALID_PARAMS_NAME("C400_3"),

    /**
     * 资源已存在
     */
    RESOURCE_EXISTS("C400_4"),

    /**
     * 该服务资源已存在
     */
    SEVICE_RESOURCE_EXISTS("C400_5"),

    /**
     * 参数类型非法
     */
    INVALID_PARAMS_TYPE("C400_6"),

    /**
     * 事件表达式错误
     */
    EVENT_EXPRESSION_ERROR("C400_7"),


    /**
     * 权限验证失败
     */
    AUTHENTICATION_FAILED("C401_1"),
    /**
     * 用户被禁用
     */
    USER_WAS_FORBIDDEN("422"),
    /**
     * perm_token失效（停用）
     */
    /* INVLID_PERM_TOKEN("C401_2"),*/
    /**
     * 用户不存在
     */
    USER_NOT_EXIST("C420_9"),
    /**
     * 资源已存在
     */
    RESOURCE_ALREADY_EXISTS("C421_1"),
    /**
     * access_token失效
     */
    INVLID_ACCESS_TOKEN("C401_3"),
    /**
     * CLIENT权限验证失败
     */
    CLIENT_AUTH_FAILED("C401_4"),

    /**
     * 密码更改致使access_token失效
     */
    TOKEN_INVLID_PSW_CHANGE("C401_5"),

    /**
     * refresh_token失效
     */
    INVLID_REFRESH_TOKEN("C401_6"),

    /**
     * 验证码错误
     */
    INVALID_SECURITY_CODE("C401_7"),

    /**
     * 非域账号
     */
    NON_REALM_ACCOUNT("C401_8"),

    /**
     * 不支持非域账号
     */
    NON_DOMAIN_ACCOUNT_IS_NOT_SUPPER("C401_9"),

    /**
     * 用户名密码不匹配
     */
    INVALID_ID_OR_PASSWORD("C402_1"),

    /**
     * 密码不符合规则
     */
    INVALID_PASSWORD_POLICY("C402_2"),

    /**
     * 用户类型错误
     */
    INVALID_USER_TYPE("C402_3"),


    /**
     * clientId验证失败
     */
    INVALID_CLIENT("C403_1"),

    /**
     * 参数有效性验证失败
     */
    PARAMETERS_VALIDATION_FAILED("2004"),
    /**
     * 基础数据未找到
     */
    BASE_DATA_NOT_FOUNT("4002"),
    /**
     * clientId验证失败
     */
    CLIENT_ID_FAILED("C403_2"),
    /**
     * clientSecert验证失败
     */
    CLIENT_SECRET_FAILED("C403_3"),



    /**
     * 未找到资源
     */
    RESOURCE_NOT_FOUND("C404_1"),

    /**
     * 未找到用户
     */
    USER_NOT_FOUND("C404_2"),

    /**
     * 未找到层级
     */
    HIERARCHY_NOT_FOUND("C404_3"),

    /**
     * 未找到服务资源
     */
    SERVICE_NOT_FOUND("C404_4"),

    /**
     * 未找到服务资源包
     */
    SERVICE_PK_NOT_FOUND("C404_5"),

    /**
     * 执行授权失败
     */
    AUTHORITY_FAILED("C406_1"),

    /**
     * 文件未知异常上传失败
     */
    FILE_UPLOAD_FAILED("C416_0"),

    /**
     * 文件过大
     */
    FILE_SIZE_TOO_LARGE("C416_1"),

    /**
     * 文件类型非法
     */
    FILE_TYPE_INVALID("C416_2"),

    /**
     * 网路中断导致文件上传失败
     */
    UPLOAD_INTERRUPT_NET("C416_3"),

    /**
     * 文件上传超时失败
     */
    UPLOAD_OVER_TIME("C416_4"),

    /**
     * 图片质量检测不合格
     */
    PIC_QUALITY_BAD("C416_5"),

    /**
     * 执行失败
     */
    FAILED("C417_1"),
    /**
     * 操作资源已发生改动
     */
    FAILED_CHANGED("C417_2"),
    /**
     * 登录用户所在组织没有iot设备模板
     */
    IOT_DEVICE_TEMPLATE_IS_NULL("C417_2"),

    /**
     * 更改保养周期失败
     */
    FAILDED_TO_MODIFY_MAINTENANCE_CYCLE("C417_4"),

    /**
     * ticket失效
     */
    TICKET_EXPIRE("C418_1"),

    /**
     * ticket已被使用
     */
    TICKET_EVER_USED("C418_2"),

    /**
     * ticket不被信任
     */
    TICKET_NOT_TRUSTED("C418_3"),
    /**
     * ticket不被信任
     */
    TICKET_NOT_FOUND("C418_4"),


    /**
     * 消息发送失败
     */
    MESSAGE_SEND_FAILED("C419_1"),


    /**
     * 验证码发送太频繁
     */
    SECURITY_CODE_SEND_LIMIT("C419_2"),

    /**
     * 消息发送太频繁
     */
    MESSAGE_SEND_LIMIT("C419_3"),

    /**
     * 文件是空的
     */
    FILE_IS_EMPTY("C420_1"),

    /**
     * 文件格式错误
     */
    FILE_FORMAT_MISSING("C420_2"),

    /**
     * 参数过长
     */
    PARAM_TOO_LENGTH("C420_3"),

    /**
     * 备件型号重复
     */
    REPEAT_MODEL("C420_4"),

    /**
     * 备件类型不存在
     */
    TYPE_NAME_NOT_EXIST("C420_5"),

    /**
     * 备件状态错误
     */
    SPARE_PARTS_STATUS_MISSING("C420_6"),

    /**
     * 活动状态错误
     */
    ACTIVITY_MISSING("C420_7"),

    /**
     * Excel的内容是空的
     */
    EXCEL_CONTENT_IS_NULL("C417_4"),

    /**
     * excel导入失败
     */
    EXCEL_IMPORT_FAIL("C417_5"),

    /**
     * 备件是无效的
     */
    SPARE_INVLID("C417_6"),

    /**
     * 备件编号规则错误
     */
    SPARE_PART_REG_ERROR("C420_8"),


    /**
     * 非管理员操作
     */
    USER_NO_IS_ADMIN("10051"),


    /**
     * 备件是无效的
     */
    CONTENT_ALREADY_EXIST("C417_7"),

    /**
     * 证书申请失败
     */
    APPLY_CERTIFICATE_FAILED("C430_1"),

    /**
     * 不能重复申请证书
     */
    APPLY_CERTIFICATE_REPETITION("C430_2"),

    /**
     * 参数缺失或者不合法
     */
    PARAMMETERS_ARE_MISSING("C430_3"),

    /**
     * 其他错误
     */
    OTHER_ERRORS("C430_4"),
    ;




    private String value;

    SubCode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
