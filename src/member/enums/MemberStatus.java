package member.enums;

/**
 * The Enum of Member subsystem
 * @date 2018-04-29
 * @category Member
 * @author William
 */
public enum MemberStatus {
	FAILURE_ACCOUNT_DUPLICATE(-1),
	FAILURE(0),
	SUCCESS(1);
	
	private int code;
	
	MemberStatus(int code) {
		this.code = code;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
}
