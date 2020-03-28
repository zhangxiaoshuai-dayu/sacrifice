package com.clound.sacrifice.dao;

import com.clound.sacrifice.module.SacrificeRegister;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zxs
 * @version 1.0
 * @date 2020/3/28 10:48
 */
@Repository
public interface SacrificeMapper {

	void registerByNote(@Param(value = "username") String username, @Param("pwd") String pwd, @Param("phoneNum") String phoneNum, @Param("sex") String sex);

	SacrificeRegister loginByPwd(@Param("phoneNum") String phoneNum, @Param("pwd") String pwd);

	SacrificeRegister VerifyOldPwd(@Param("oldPwd") String oldPwd, @Param("phoneNum") String phoneNum);

	void changePwd(@Param("phoneNum") String phoneNum, @Param("newPwd") String newPwd);
}