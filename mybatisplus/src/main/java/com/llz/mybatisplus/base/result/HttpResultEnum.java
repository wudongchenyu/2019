package com.llz.mybatisplus.base.result;

public enum HttpResultEnum {
	
	SUCCESS(100000,"接口请求成功"),
	FAILED(200000,"接口请求失败"),
	ERROR(300000,"接口出错");
	
	private Integer value;
	
	private String message;
	
	HttpResultEnum(Integer value, String message) {
		this.value = value;
		this.message = message;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
