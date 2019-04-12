package jingcheng.utils.response;

import java.io.Serializable;

/**
 * 请求响应
 * @author WinZhong
 * @param <T>
 *
 */
public class ReqResponse<T> implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//响应代码CODE  成功返回0000   默认0000
	private String code = "0000";
	//响应信息
	private String message = "";
	//返回数据
	private T result;
	/**
	 * 响应代码CODE  成功返回0   默认0
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 响应代码CODE  成功返回0   默认0
	 * @param code
	 */
	public void setCode(String code) {
        this.code = code;
	}
	/**
	 * 响应信息
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 响应信息
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
 
	/**
	 * 返回数据
	 * @return
	 */
	public T getResult() {
		return result;
	}
	/**
	 * 返回数据
	 * @param result
	 */
	public void setResult(T result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ReqResponse [code=" + code + ", message=" + message + ", result=" + result + "]";
	}

}
