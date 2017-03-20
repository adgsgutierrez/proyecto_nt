package co.com.konrad.nt.dto;

public class ResponseNT {

	private String code;
	private String message;
	private Object data;
		
	@Override
	public String toString() {
		return "ResponseNT [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
