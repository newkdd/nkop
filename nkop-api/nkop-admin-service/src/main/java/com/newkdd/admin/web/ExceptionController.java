package com.newkdd.admin.web;

import com.newkdd.framework.config.Constant;
import com.newkdd.framework.exception.BizException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户控制层
 * @author mike.miao
 *
 */
@RestController
@RequestMapping("/error/web")
@Api(value = "ExceptionController", description="系统异常接口")
public class ExceptionController {

    /**
     * 异常测试
     * @return
     */
    @ApiOperation(value = "业务异常", notes = "业务异常")
    @GetMapping(value = "v1/g/throw_biz_error", produces = {"application/json;charset=UTF-8"})
    public void throwBizException(@RequestParam String code, @RequestParam(required=false) String message, @RequestParam(required=false) Integer responseStatus) {
        if(StringUtils.isNotBlank(code)&&StringUtils.isNotBlank(message)&&null!=responseStatus){
            throw new BizException(code,message,responseStatus);
        }else if(StringUtils.isNotBlank(code)&&StringUtils.isNotBlank(message)){
            throw new BizException(code,message);
        }else if(StringUtils.isNotBlank(code)&&null!=responseStatus){
            throw new BizException(code,responseStatus);
        }else if(StringUtils.isNotBlank(code)){
            throw new BizException(code);
        }else{
            throw new BizException(Constant.EXCEPTION.DEFAULT);
        }
    }

    /**
     * 异常测试,经测试没有进入异常统一处理方法
     * @return
     */
    @ApiOperation(value = "系统运行异常", notes = "系统运行异常")
    @GetMapping(value = "v1/g/throw_run_error", produces = {"application/json;charset=UTF-8"})
    public void throwRunException() {
        throw new RuntimeException();
    }
}
