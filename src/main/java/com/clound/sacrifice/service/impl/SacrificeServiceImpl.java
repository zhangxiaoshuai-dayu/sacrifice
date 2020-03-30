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
			//去重
			SacrificeRegister sacrificeRegister = sacrificeMapper.checkUser(phoneNum);
			if (sacrificeRegister != null) {
				result = new Result(false, BaseEnums.OPERATION_FAILURE.code(), "该手机号已注册，请直接登录");
			} else {
				//注册
				sacrificeMapper.registerByNote(username, pwd, phoneNum);
				result = new Result(true, BaseEnums.OPERATION_SUCCESS.code(), "注册成功");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = new Result(false, BaseEnums.OPERATION_FAILURE.code(), "注册失败");
		}
		return result;
	}

	@Override
	public Result loginByPwd(Map map) {
		Result result;
		try {
			String phoneNum = (String) map.get("phoneNum");
			String pwd = (String) map.get("pwd");
			SacrificeRegister sacrificeRegister = sacrificeMapper.loginByPwd(phoneNum, pwd);
			if (sacrificeRegister != null) {
				String token = TokenUtils.token("phoneNum", "pwd");
				result = new Result(true, BaseEnums.OPERATION_SUCCESS.code(), "登录成功", token);
			} else {
				result = new Result(false, BaseEnums.OPERATION_FAILURE.code(), "登录失败，请确定账号已注册或账号密码信息正确");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = new Result(false, BaseEnums.OPERATION_FAILURE.code(), "登录失败，系统异常");
		}
		return result;
	}

	@Override
	public Result VerifyOldPwd(Map map) {
		Result result;
		String tokenNew = null;
		String oldPwd = (String) map.get("oldPwd");
		String phoneNum = (String) map.get("phoneNum");
		String token = (String) map.get("token");
		boolean verify = TokenUtils.verify(token);
		if (!verify) {
			tokenNew = TokenUtils.token(phoneNum, oldPwd);
		}
		SacrificeRegister sacrificeRegister = sacrificeMapper.VerifyOldPwd(oldPwd, phoneNum);
		if (sacrificeRegister != null) {
			result = new Result(true, BaseEnums.SUCCESS.code(), "校验成功", tokenNew);
		} else {
			result = new Result(false, BaseEnums.FAILURE.code(), "原始密码错误，请重新输入", tokenNew);
		}
		return result;
	}

	@Override
	public Result changePwd(Map map) {


		Result result = null;
		String tokenNew = null;
		String newPwd = (String) map.get("newPwd");
		String phoneNum = (String) map.get("phoneNum");
		String token = (String) map.get("token");
		boolean verify = TokenUtils.verify(token);
		if (!verify) {
			tokenNew = TokenUtils.token(phoneNum, newPwd);
		}
		try {
			sacrificeMapper.changePwd(phoneNum, newPwd);
			result = new Result(true, BaseEnums.SUCCESS.code(), "修改成功", tokenNew);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = new Result(false, BaseEnums.FAILURE.code(), "修改失败", tokenNew);
		}
		return result;
	}


}
