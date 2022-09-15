package com.ethanChan.springBatchDbExample.dto;

import com.ethanChan.springBatchDbExample.exception.UniExceptionEnums;
import com.ethanChan.springBatchDbExample.exception.UniRuntimeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  统一返回类
 * @author mason
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseResult<T> {
	private boolean success;
	private String errCode;
	private String errShowMsg;
	private String errMsg;
	private T resultData;

	public static ResponseResult of(boolean success,Object resultData,String errCode,String errShowMsg, String errMsg) {
		return new ResponseResult(success,errCode, errShowMsg,errMsg,resultData);
	}

	public static ResponseResult ok(Object resultData) {
		return of(true,resultData,null,null,null);
	}

	public static ResponseResult err(String errCode,String errShowMsg,String errMsg) {
		return of(false,null, errCode,errShowMsg,errMsg);
	}

	public static ResponseResult err(UniExceptionEnums uniExceptionEnums) {
		return of(false,null, uniExceptionEnums.getErrCode(),uniExceptionEnums.getErrShowMsg(),null);
	}

	public static ResponseResult err(UniExceptionEnums uniExceptionEnums,Exception e) {
		return of(false,null, uniExceptionEnums.getErrCode(),uniExceptionEnums.getErrShowMsg(),e.getMessage());
	}

	public static ResponseResult err(UniRuntimeException e) {
		return of(false,null, e.getErrCode(),e.getErrShowMsg(),e.getMessage());
	}
}
