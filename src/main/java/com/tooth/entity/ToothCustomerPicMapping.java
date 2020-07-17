package com.tooth.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tooth_customer
 * @author 
 */
@Data
public class ToothCustomerPicMapping implements Serializable {
    private String soeId;

    private String userName;

    private String name;

    private String phoneNum;

    private String email;

    private Date createdTime;

    private String createBy;

    private Date modifiedTime;

    private String modifyBy;

    private String status;

    private static final long serialVersionUID = 1L;
}