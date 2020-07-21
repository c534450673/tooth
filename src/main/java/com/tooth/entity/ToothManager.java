package com.tooth.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.tooth.model.BaseModel;
import lombok.Builder;
import lombok.Data;

/**
 * tooth_customer
 * @author 
 */
@Data
@Builder
public class ToothManager extends BaseModel<ToothManager> implements Serializable {
    @TableField(value = "SOE_ID")
    private String soeId;

    @TableField(value = "USER_NAME")
    private String userName;

    @TableField(value = "NAME")
    private String name;

    @TableField(value = "PHONE_NUM")
    private String phoneNum;

    @TableField(value = "EMAIL")
    private String email;

    @TableField(value = "CREATED_TIME")
    private Date createdTime;

    @TableField(value = "CREATE_BY")
    private String createBy;

    @TableField(value = "MODIFIED_TIME")
    private Date modifiedTime;

    @TableField(value = "MODIFY_BY")
    private String modifyBy;

    @TableField(value = "STATUS")
    private String status;

    private static final long serialVersionUID = 1L;
}