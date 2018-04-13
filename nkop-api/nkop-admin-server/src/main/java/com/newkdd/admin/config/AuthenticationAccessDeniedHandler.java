package com.newkdd.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newkdd.framework.basic.response.ErrorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sang on 2017/12/29.
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Resource
    private MessageSource messageSource;
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String errorCode = "EK.ERR.403001";
        Locale locale = LocaleContextHolder.getLocale();
        String error = messageSource.getMessage(errorCode,null,locale);
        ErrorResponse errorResponse = new ErrorResponse(errorCode,error);
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(errorResponse));
        out.flush();
        out.close();
    }
}
