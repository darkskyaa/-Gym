package inbody.enums;

/**
 * The Enum of Inbody subsystem
 * @date 2018-05-06
 * @category Inbody
 * @author William
 */
public enum InbodyStatus {
	FAILURE(0),
	SUCCESS(1);
	
	private int code;
	
	InbodyStatus(int code) {
		this.code = code;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
}
