package com.clound.sacrifice.utils;

/**
 * 基础枚举接口
 *
 * @author cuiyg 2018-07-18
 * @version 1.0
 */
public interface BaseEnum<K, V> {

	/**
	 * 获取编码
	 *
	 * @return 编码
	 */
	K code();

	/**
	 * 获取描述
	 *
	 * @return 描述
	 */
	V desc();

}