package com.lidong.dubbo.web.websocket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class WebSocketSessionHandshakeInterceptor extends
		HttpSessionHandshakeInterceptor {
	Logger logger = LoggerFactory
			.getLogger(WebSocketSessionHandshakeInterceptor.class);

	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response,
			org.springframework.web.socket.WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		 System.out.println("--------------------start--------------------------"); 
		 System.out.println("hi get request."); 
		if (getSession(request) != null) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpServletRequest httpServletRequest = servletRequest
					.getServletRequest();
			String userName = httpServletRequest.getParameter("userName");
			 System.out.println("a client userName=" + userName);  
			attributes.put("userId", userName);
		}

		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response,
			org.springframework.web.socket.WebSocketHandler wsHandler,
			Exception ex) {
		super.afterHandshake(request, response, wsHandler, ex);
	}

	private HttpSession getSession(ServerHttpRequest request) {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
			return serverRequest.getServletRequest().getSession();
		}
		return null;
	}
}