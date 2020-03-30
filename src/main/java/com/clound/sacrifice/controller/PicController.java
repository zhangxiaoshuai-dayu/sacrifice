package com.clound.sacrifice.controller;

import com.clound.sacrifice.module.HeroPic;
import com.clound.sacrifice.service.PicService;
import com.clound.sacrifice.utils.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 处理图片
 * @author zxs
 * @version 1.0
 * @date 2020/3/30 18:59
 */
@RestController
@RequestMapping("/pic")
public class PicController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PicController.class);

	@Autowired
	public PicService picService;

	/**
	 *
	 * @return
	 */
	@PostMapping("/upPic")
	public Result upPIc(){
		return null;
	}

	/**
	 * 返回轮播图与首页图片
	 * @return
	 */

	@GetMapping("/getPic")
	public Result getPIc(){
		LOGGER.info("开始获取图片");
		Result result =picService.getPIc();
		LOGGER.info("获取图片结束");
		return result;
	}


}
