package com.hd.oms.component;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hd.oms.common.CommonResult;

@RestControllerAdvice
public class GlobalExceptionHandle {

	/**
	 * 
	    * @Title: handleBindException
	    * @Description: 捕获requestbody校验不通过
	    * @param @param ex
	    * @param @return    参数
	    * @return CommonResult<?>    返回类型
	    * @throws
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResult<?> handleBindException(MethodArgumentNotValidException ex) {
		FieldError fieldError = ex.getBindingResult().getFieldError();
		return CommonResult.validateFailed(fieldError.getDefaultMessage());
	}

	/**
	 * 
	    * @Title: handleBindException
	    * @Description: 捕获除requestbody外的校验不通过
	    * @param @param ex
	    * @param @return    参数
	    * @return CommonResult<?>    返回类型
	    * @throws
	 */
	@ExceptionHandler(BindException.class)
	public CommonResult<?> handleBindException(BindException ex) {
		// 校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
		FieldError fieldError = ex.getBindingResult().getFieldError();
		return CommonResult.validateFailed(fieldError.getDefaultMessage());
	}
}
