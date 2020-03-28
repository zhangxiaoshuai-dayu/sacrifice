package com.clound.sacrifice.controller;

import com.clound.sacrifice.service.SacrificeService;
import com.clound.sacrifice.utils.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author zxs
 * @version 1.0
 * @date 2020/3/28 9:37
 */
@RestController
@RequestMapping("/sacri")
public class SacrificeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SacrificeController.class);

	@Autowired
	public SacrificeService sacrificeService;

	/**
	 * 注册
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "registerByNo", method = RequestMethod.POST)
	public Result registerByNote(@RequestBody Map map) {
		LOGGER.info("注册开始");
		Result result = sacrificeService.registerByNote(map);
		LOGGER.info("注册结束");
		return result;
	}

	/**
	 * 登录
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "loginByPwd", method = RequestMethod.POST)
	public Result loginByPwd(@RequestBody Map map) {
		LOGGER.info("登录开始");
		Result result = sacrificeService.loginByPwd(map);
		LOGGER.info("登录结束");
		return result;
	}

	/**
	 * 修改密码一，校验原始密码
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "VerifyOldPwd", method = RequestMethod.POST)
	public Result VerifyOldPwd(@RequestBody Map map) {
		LOGGER.info("校验密码开始");
		Result result = sacrificeService.VerifyOldPwd(map);
		LOGGER.info("检验密码结束");
		return result;
	}

	/**
	 * 修改密码二，修改密码
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "changePwd", method = RequestMethod.POST)
	public Result changePwd(@RequestBody Map map) {
		LOGGER.info("修改密码开始");
		Result result = sacrificeService.changePwd(map);
		LOGGER.info("修改密码结束");
		return result;
	}
}
