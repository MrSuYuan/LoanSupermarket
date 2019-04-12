package jingcheng.utils.exception;

/**
 * 自定义异常
 * @author WinZhong
 * @date 2017年10月5日 下午6:12:21
 */
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String message;
    private String code = "500";
    
    public CustomException(String message) {
		super(message);
		this.message = message;
	}
	
	public CustomException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}
	
	public CustomException(String message, String code) {
		super(message);
		this.message = message;
		this.code = code;
	}
	
	public CustomException(String message, String code, Throwable e) {
		super(message, e);
		this.message = message;
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	 
	
}
