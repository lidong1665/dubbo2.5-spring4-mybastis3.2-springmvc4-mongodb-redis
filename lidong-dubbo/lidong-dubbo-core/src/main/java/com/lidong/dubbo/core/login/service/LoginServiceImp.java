package com.lidong.dubbo.core.login.service;

import com.lidong.dubbo.api.login.service.ILoginService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("loginServices")
public class LoginServiceImp implements ILoginService {

	@Override
    public Map<String, Object> login(Map<String, Object> map) {
		return map;
	}

}