package com.clound.sacrifice.utils;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 前端返回对象
 *
 * @author cuiyg 2017-12-28
 * @version 1.0
 */
public class Result implements Serializable {
	private static final long serialVersionUID = 1430633339880116031L;

	/**
	 * 成功与否标志
	 */
	private boolean success = true;
	/**
	 * 返回状态码，为空则默认200.前端需要拦截一些常见的状态码如403、404、500等
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer status;
	/**
	 * 编码，可用于前端处理多语言，不需要则不用返回编码
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String code;
	/**
	 * 相关消息
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String msg;
	/**
	 * 相关数据
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data1;
	/**
	 * 相关数据
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data2;
	/**
	 * 相关数据
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data3;
	/**
	 * 相关数据
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data4;


	public Result() {
	}

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, Integer status) {
		this.success = success;
		this.status = status;
	}

	public Result(boolean success, String code, String msg) {
		this(success);
		this.code = code;
		this.msg = msg;
	}

	public Result(boolean success, Integer status, String code, String msg) {
		this.success = success;
		this.status = status;
		this.code = code;
		this.msg = msg;
	}

	public Result(boolean success, String code, String msg, Object data) {
		this(success);
		this.code = code;
		this.msg = msg;
		this.data1 = data;
	}

	public Result(boolean success, String code, String msg, Object data1, Object data2) {
		this(success);
		this.code = code;
		this.msg = msg;
		this.data1 = data1;
		this.data2 = data2;
	}

	public Result(boolean success, String code, String msg, Object data1, Object data2, Object data3) {
		this(success);
		this.code = code;
		this.msg = msg;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}

	public Result(boolean success, String code, String msg, Object data1, Object data2, Object data3, Object data4) {
		this(success);
		this.code = code;
		this.msg = msg;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data1;
	}

	public void setData(Object data) {
		this.data1 = data;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Object getData2() {
		return data2;
	}

	public void setData2(Object data2) {
		this.data2 = data2;
	}

	public Object getData3() {
		return data3;
	}

	public void setData3(Object data3) {
		this.data3 = data3;
	}

	public Object getData4() {
		return data4;
	}

	public void setData4(Object data4) {
		this.data4 = data4;
	}
}
