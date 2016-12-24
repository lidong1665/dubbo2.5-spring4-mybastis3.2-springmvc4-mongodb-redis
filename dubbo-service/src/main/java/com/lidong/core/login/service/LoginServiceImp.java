package com.lidong.core.login.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.lidong.api.service.login.ILoginService;
@Service("loginServices")
public class LoginServiceImp implements ILoginService{

	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		return map;
	}

}
