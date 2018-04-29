package member.enums;

public enum MemberStatus {
	FAILURE_ACCOUNT_DUPLICATE(-1),
	FAILURE(0),
	SUCCESS(1);
	
	private int code;
	
	MemberStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
