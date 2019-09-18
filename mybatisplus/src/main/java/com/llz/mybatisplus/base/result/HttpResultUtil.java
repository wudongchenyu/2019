package com.llz.mybatisplus.base.result;

import org.springframework.http.HttpStatus;

public class HttpResultUtil {
	
	public static <T> HttpResult<T> success() {
		return new HttpResult<T>().success(true).setEnum(HttpResultEnum.SUCCESS).status(HttpStatus.OK);
	}
	
	public static <T> HttpResult<T> success(T data) {
		return new HttpResult<T>().success(true).setEnum(HttpResultEnum.SUCCESS).status(HttpStatus.OK).data(data);
	}
	
	public static <T> HttpResult<T> success(HttpResultEnum e, T data) {
		return new HttpResult<T>().success(true).setEnum(e).status(HttpStatus.OK).data(data);
	}
	
	public static <T> HttpResult<T> success(HttpResultEnum e) {
		return new HttpResult<T>().success(true).setEnum(e).status(HttpStatus.OK);
	}
	
	public static <T> HttpResult<T> error(HttpResultEnum e, T data) {
		return new HttpResult<T>().success(false).setEnum(e).status(HttpStatus.INTERNAL_SERVER_ERROR).data(data);
	}
	
	public static <T> HttpResult<T> error(HttpResultEnum e) {
		return new HttpResult<T>().success(false).setEnum(e).status(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static <T> HttpResult<T> error(T data) {
		return new HttpResult<T>().success(false).setEnum(HttpResultEnum.ERROR).status(HttpStatus.INTERNAL_SERVER_ERROR).data(data);
	}
	
	public static <T> HttpResult<T> error() {
		return new HttpResult<T>().success(false).setEnum(HttpResultEnum.ERROR).status(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static <T> HttpResult<T> failed(HttpResultEnum e, T data) {
		return new HttpResult<T>().success(false).setEnum(e).status(HttpStatus.OK).data(data);
	}
	
	public static <T> HttpResult<T> failed(HttpResultEnum e) {
		return new HttpResult<T>().success(false).setEnum(e).status(HttpStatus.OK);
	}
	
	public static <T> HttpResult<T> failed(T data) {
		return new HttpResult<T>().success(false).setEnum(HttpResultEnum.FAILED).status(HttpStatus.OK).data(data);
	}
	
	public static <T> HttpResult<T> failed() {
		return new HttpResult<T>().success(false).setEnum(HttpResultEnum.FAILED).status(HttpStatus.OK);
	}
	
	//返回结果集设置
	public static <T> HttpResult<T> result(T data) {
		if (null == data) {
			return new HttpResult<T>().success(false).setEnum(HttpResultEnum.FAILED).status(HttpStatus.OK);
		}
		
		if (data instanceof Boolean) {
			if ((boolean) data) {
				return new HttpResult<T>().success(true).setEnum(HttpResultEnum.SUCCESS).status(HttpStatus.OK).data(data);
			}else {
				return new HttpResult<T>().success(false).setEnum(HttpResultEnum.FAILED).status(HttpStatus.OK).data(data);
			}
		}
		return new HttpResult<T>().success(true).setEnum(HttpResultEnum.SUCCESS).status(HttpStatus.OK).data(data);
	}

}
