package com.tooth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tooth_customer
 * @author 
 */
@Data
public class ToothCustomer implements Serializable {
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