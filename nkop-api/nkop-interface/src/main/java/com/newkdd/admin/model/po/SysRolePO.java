package com.newkdd.admin.model.po;

import com.newkdd.framework.basic.BasicPO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "TB_SYS_ROLE")
public class SysRolePO extends BasicPO {

    @Column(name = "CODE")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "remark")
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}