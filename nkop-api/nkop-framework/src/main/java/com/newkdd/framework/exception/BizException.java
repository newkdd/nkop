package com.newkdd.framework.exception;


public class BizException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	/**异常编码*/
	private String code = "";
	/**请求返回状态码*/
	private Integer responseStatus = null;

	/**
	 * 从国际化里面获取错误描述
	 * @param code * 错误码
	 */
	public BizException(String code){
		this.code = code;
	}

	/**
	 * @param code * 错误码
	 * @param message * 错误描述
	 */
	public BizException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * @param code * 错误码
	 * @param responseStatus * http状态码
	 */
	public BizException(String code, Integer responseStatus) {
		this.code = code;
		this.responseStatus = responseStatus;
	}


	/**
	 * @param code * 错误码
	 * @param message * 错误描述
	 * @param responseStatus * http状态码
	 */
	public BizException(String code, String message, Integer responseStatus) {
		super(message);
		this.code = code;
		this.responseStatus = responseStatus;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}
}
