package com.tooth.entity;

import java.io.Serializable;
import java.util.Date;

import com.tooth.model.BaseModel;
import lombok.Data;

/**
 * tooth_access_token
 * @author 
 */
@Data
public class ToothAccessToken extends BaseModel<ToothAccessToken> implements Serializable {
    private Integer id;

    private String soeId;

    private String accessToken;

    private Date createdTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;
}