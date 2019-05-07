package com.ice.springboot.advice;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice()     // 作为一个控制层切面处理
@RestControllerAdvice
public class GlobalExceptionAdvice {


    public static final String DEFAULT_ERROR_VIEW = "error";

//    @ExceptionHandler(value = Exception.class)  // 所有的异常都是Exception的子类
    public ModelAndView defaultErrorHandler(Exception e) {   // 出现异常会跳到此方法
        // 后去request方式1
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取request方式2
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request1 = requestAttributes.getRequest();

        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        mav.addObject("url", request1.getRequestURL());
        mav.addObject("exception", e);

        return mav;

    }

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorAnotherHandler(HttpServletRequest request, Exception e){

        class ErrorInfo{
            private int code;
            private String message;
            private String url;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode(100);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }


}
