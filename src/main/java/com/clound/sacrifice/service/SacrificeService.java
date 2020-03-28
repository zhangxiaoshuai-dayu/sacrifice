package com.clound.sacrifice.service;


import com.clound.sacrifice.utils.Result;

import java.util.Map;


/**
 * @author zxs
 * @version 1.0
 * @date 2020/3/28 10:13
 */

public interface SacrificeService {

	Result registerByNote(Map map);

	Result loginByPwd(Map map);

	Result VerifyOldPwd(Map map);

	Result changePwd(Map map);
}