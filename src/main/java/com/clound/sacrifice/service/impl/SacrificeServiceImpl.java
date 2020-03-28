package com.clound.sacrifice.service.impl;

import com.clound.sacrifice.dao.SacrificeMapper;
import com.clound.sacrifice.module.SacrificeRegister;
import com.clound.sacrifice.service.SacrificeService;
import com.clound.sacrifice.utils.BaseEnums;
import com.clound.sacrifice.utils.Result;
import com.clound.sacrifice.utils.TokenUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @author zxs
 * @version 1.0
 * @date 2020/3/28 10:15
 */
@Service
public class SacrificeServiceImpl implements SacrificeService {
	@Autowired
	public SacrificeMapper sacrificeMapper;

	@Override
	public Result registerByNote(Map map) {
		Result result;
		try {
			String username = (String) map.get("username");
			String pwd = (String) map.get("pwd");
			String phoneNum = (String) map.get("phoneNum");
			String sex = (String) map.get("sex");
			sacrificeMapper.registerByNote(username, pwd, phoneNum, sex);
			result = new Result(true, BaseEnums.OPERATION_SUCCESS.code(), "注册成功");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = new Result(true, BaseEnums.OPERATION_FAILURE.code(), "注册失败");
		}
		return result;
	}

	@Override
	public Result loginByPwd(Map map) {
		Result result;
		try {
			String phoneNum = (String) map.get("phoneNum");
			String pwd = (String) map.get("pwd");
			SacrificeRegister sacrificeRegister = sacrificeMapper.loginByPwd( phoneNum, pwd);
			if (sacrificeRegister != null) {
				String token = TokenUtils.token("phoneNum", "pwd");
				result = new Result(true, BaseEnums.OPERATION_SUCCESS.code(), "登录成功",token);
			} else {
				result = new Result(true, BaseEnums.OPERATION_FAILURE.code(), "登录失败，请检查登录信息");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = new Result(true, BaseEnums.OPERATION_FAILURE.code(), "登录失败，请检查登录信息");
		}
		return result;
	}
}
