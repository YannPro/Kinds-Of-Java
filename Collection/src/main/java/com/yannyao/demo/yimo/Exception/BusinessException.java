package com.yannyao.demo.yimo.Exception;

/**
 * Created by didi on 2017/7/10.
 */
public class BusinessException extends RuntimeException implements ApiErrors {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int result;
	private String errMsg;
	private String error;

	public BusinessException(int result, String error , String errMsg) {
		super(result + ":" + errMsg);
		this.result = result;
		this.errMsg = errMsg;
		this.error=error;
	}
	public BusinessException(ApiErrors errors) {
		this(errors.getResult(),errors.getError(), errors.getErrMsg());
	}

	public BusinessException(String errMsg,ApiErrors errors) {
		this(errors.getResult(),errors.getErrMsg(),errMsg);

	}


	public BusinessException(ApiErrors errors, Object... args) {
		this(errors.getResult(),errors.getError(), String.format(errors.getErrMsg(), args));
	}




	@Override
	public int getResult() {
		return this.result;
	}

	@Override
	public String getError() {
		return this.error;
	}

	@Override
	public String getErrMsg() {
		return this.errMsg;
	}

}
