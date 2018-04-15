package com.newkdd.framework.basic;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *  View Object 页面对象
 * @author Mike
 *
 */
public class BasicVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 编码*/
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
