package com.hd.oms.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.hd.oms.common.CommonResult;

import cn.hutool.json.JSONUtil;

/**
 * 
 * @ClassName: RestAuthenticationEntryPoint
 * @Description: 当未登录或者token失效访问接口时，自定义的返回结果
 * @author wqy
 * @date 2019年8月20日
 *
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
		response.getWriter().flush();
	}
}
