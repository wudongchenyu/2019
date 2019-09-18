package com.llz.mybatisplus.base.result;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import jdk.jfr.Description;

public class HttpResult<T> {
	
	@Description(value = "接口HttpStatus")
	private HttpStatus status;
	
	@Description(value = "接口业务操作码")
	private Integer code;
	
	@Description(value = "接口业务操作码说明")
	private String message;
	
	@Description(value = "接口是否访问成功")
	private boolean success;
	
	@Description(value = "接口返回时间戳")
	private LocalDateTime timestamp;
	
	@Description(value = "接口返回业务数据")
	private T data;
	
	public HttpResult<T> status(HttpStatus status) {
		this.status = status;
		return this;
	}
	
	public HttpResult<T> code(Integer code) {
		this.code = code;
		return this;
	}
	
	public HttpResult<T> message(String message) {
		this.message = message;
		return this;
	}
	
	public HttpResult<T> success(boolean success) {
		this.success = success;
		return this;
	}
	
	public HttpResult<T> timestamp() {
		this.timestamp = LocalDateTime.now();
		return this;
	}
	
	public HttpResult<T> data(T data) {
		this.data = data;
		return this;
	}
	
	public HttpResult<T> setEnum(HttpResultEnum e) {
		this.code = e.getValue();
		this.message = e.getMessage();
		return this;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	
	public HttpResult() {
		this.timestamp = LocalDateTime.now();
	}
	
}
