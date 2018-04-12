package com.newkdd.framework.basic;

import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tk.mybatis.mapper.annotation.ColumnType;

/**
 * 数据对象
 *
 * @author Mike
 */
@Entity
public class BasicPO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private String id;

  /**
   * 创建人
   */
  @Column(name = "CREATED_BY")
  private String createdBy;

  /**
   * 创建时间
   */
  @Column(name = "CREATED_DATE")
  @ColumnType(jdbcType = JdbcType.TIMESTAMP)
  private Timestamp createdDate;

  /**
   * 最后修改人
   */
  @Column(name = "MODIFIED_BY")
  private String modifiedBy;

  /**
   * 最后修改时间
   */
  @Column(name = "MODIFIED_DATE")
  @ColumnType(jdbcType = JdbcType.TIMESTAMP)
  private Timestamp modifiedDate;

  /**
   * 数据版本，用于并发逻辑控制
   */
  @Column(name = "version")
  @ColumnType(jdbcType = JdbcType.BIGINT)
  private Long version;

  /**
   * 数据有效：[1：有效；0：无效；]
   */
  @Column(name = "ENABLED")
  @ColumnType(jdbcType = JdbcType.TINYINT)
  private Integer enabled;


  /**
   * 删除状态：[1：已删除；0：未删除；]
   */
  @Column(name = "DELETED")
  @ColumnType(jdbcType = JdbcType.TINYINT)
  private Integer deleted;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Timestamp getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Timestamp modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Integer getEnabled() {
    return enabled;
  }

  public void setEnabled(Integer enabled) {
    this.enabled = enabled;
  }

  public Integer getDeleted() {
    return deleted;
  }

  public void setDeleted(Integer deleted) {
    this.deleted = deleted;
  }
}
