package com.tooth.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;

/**
 * @author subo.zhang
 * @description
 * @date 2020/7/17
 * @company own
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseModel<T extends BaseModel<?>> extends Model<T> {

    /**
     *
     */
    private static final long serialVersionUID = -8834666751994627930L;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;
    @TableField(value = "CREATED_TIME", jdbcType = JdbcType.TIMESTAMP)
    private Timestamp createdTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifiedBy;
    @TableField(value = "MODIFIED_TIME", update = "SYSTIMESTAMP", fill = FieldFill.UPDATE, jdbcType = JdbcType.TIMESTAMP)
    private Timestamp modifiedTime;

    @Override
    public <E extends IPage<T>> E selectPage(E page, Wrapper<T> queryWrapper) {
        page = super.selectPage(page, queryWrapper);
        if(page.getRecords() instanceof PageList) {
            PageList<T> pageList = (PageList<T>)page.getRecords();
            page.setRecords(pageList.getRecords());
            page.setTotal(pageList.getTotal());
        }
        return page;
    }

}
