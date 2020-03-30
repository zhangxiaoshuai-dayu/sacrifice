package com.clound.sacrifice.service.impl;

import com.clound.sacrifice.dao.Picmapper;
import com.clound.sacrifice.module.HeroPic;
import com.clound.sacrifice.service.PicService;
import com.clound.sacrifice.utils.BaseEnums;
import com.clound.sacrifice.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxs
 * @version 1.0
 * @date 2020/3/30 19:08
 */
@Service
public class PicServiceImpl implements PicService {

	@Autowired
	public Picmapper picMapping;


	@Override
	public Result getPIc() {
		Result result;
		try {
			List<HeroPic> heroPicListLast = picMapping.getLastPic();
			List<HeroPic> heroPicListFirst = picMapping.getFirstPic();
			if (heroPicListLast.size() == 0 || heroPicListFirst.size() == 0) {
				result = new Result(false, BaseEnums.OPERATION_FAILURE.code(), "请先上传轮播图或示例图");
			} else {
				result = new Result(true, BaseEnums.OPERATION_SUCCESS.code(), BaseEnums.OPERATION_SUCCESS.desc(), heroPicListFirst, heroPicListLast);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new Result(false, BaseEnums.OPERATION_FAILURE.code(), "图片查询失败，请联系系统管理员！");
		}
		return result;
	}
}
