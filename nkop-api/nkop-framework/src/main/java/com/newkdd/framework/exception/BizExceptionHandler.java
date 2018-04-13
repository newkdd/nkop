package com.newkdd.framework.exception;

import com.newkdd.framework.basic.response.ErrorResponse;
import com.newkdd.framework.config.Constant;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理类
 * 
 * @since
 *
 */
@ControllerAdvice
public class BizExceptionHandler {
	@Resource
	private MessageSource messageSource;
	
	//添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例  
    @ExceptionHandler(value=BizException.class)
    @ResponseBody
    public ErrorResponse bizExceptionHandler(HttpServletRequest request, HttpServletResponse response, BizException ex) throws Exception
    {
    	//默认服务器运行错误
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ErrorResponse errorResponse = new ErrorResponse();
		if(ex instanceof  BizException){
			BizException exception=(BizException) ex;
			if(StringUtils.isNotBlank(exception.getCode())){
				Locale locale = LocaleContextHolder.getLocale();
				errorResponse.setCode(exception.getCode());
				errorResponse.setError(exception.getMessage()==null?messageSource.getMessage(exception.getCode(),null,locale):exception.getMessage());
			}else {
				errorResponse.setCode(exception.getCode());
				errorResponse.setError(exception.getMessage());
			}
			//设置http状态码
			if(null!=exception.getResponseStatus()){
				response.setStatus(exception.getResponseStatus());
			}
		}else{
			Locale locale = LocaleContextHolder.getLocale();
			errorResponse.setCode(Constant.EXCEPTION.DEFAULT);
			errorResponse.setError(messageSource.getMessage(Constant.EXCEPTION.DEFAULT,null,locale));
		}
		errorResponse.setStack(getExceptionDetail(ex));
		return errorResponse;
    }  

	/**
	 * 获取异常堆栈信息
	 *
	 * @param ex
	 * @return
	 */
	public String getExceptionDetail(Throwable ex) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		ex.printStackTrace(printWriter);
		return result.toString();
	}

}
