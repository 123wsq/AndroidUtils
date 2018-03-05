package com.wsq.library.utils;

import android.text.TextUtils;

import com.wsq.library.exception.ErrorCode;
import com.wsq.library.exception.WException;

import java.util.Iterator;
import java.util.Map;


/**
 * 参数验证
 * @author wsq
 *
 */
public class ParamValidate {

	/**
	 * 验证多个值
	 * @param param
	 * @throws Exception
	 */
	public static void validate(String...param) throws WException {

		if (param == null) {
			throw new WException("参数为空");
		}

		for (int i = 0; i < param.length; i++) {

			if (TextUtils.isEmpty(param[i])) {
				throw new WException(ErrorCode.EX_H0002.getCode(), ErrorCode.EX_H0002.getMsg());
			}
		}
	}

	/**
	 * 验证多个值
	 * @param param
	 * @throws Exception
	 */
	public static void validate(Map<String, String> param) throws WException{

		if (param == null) {
			throw new WException("参数为空");
		}

		Iterator<Map.Entry<String, String>> iterator = param.entrySet().iterator();

		while (iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();

			if (TextUtils.isEmpty(entry.getValue())){
				throw  new WException(ErrorCode.EX_H0002.getCode(), ErrorCode.EX_H0002.getMsg()+":"+entry.getValue());
			}
		}
	}

	/**
	 * 验证必要参数是否为空
	 * @param param
	 * @param values
	 * @throws Exception
	 */
	public static void validate(Map<String, String> param, String... values) throws WException{

		for (int i = 0; i < values.length; i++) {

			if (param.containsKey(values[i])){

				String value = param.get(values[i]);
				if (TextUtils.isEmpty(value)){

					throw new WException(ErrorCode.EX_H0002.getCode(), ErrorCode.EX_H0002.getMsg()+":"+value);
				}
			}else {
				throw new WException(ErrorCode.EX_H0002.getCode(), ErrorCode.EX_H0002.getMsg()+":"+ values[i]);
			}
		}

	}

}
