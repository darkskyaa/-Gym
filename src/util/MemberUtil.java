package util;

import member.pojo.MemberBean;

public class MemberUtil {
	
	public static StringBuilder checkMember(MemberBean member, boolean idCheckRequired) {
		StringBuilder result = new StringBuilder();
		if (idCheckRequired && member.getId() == null) {
			result.append("field 'id' must be filled\n");
		}
		if (member.getAccount() == null) {
			result.append("field 'account' must be filled\n");
		}
		if (member.getPassword() == null) {
			result.append("field 'password' must be filled\n");
		}
		if (member.getName() == null) {
			result.append("field 'name' must be filled\n");
		}
		if (member.getSex() == null) {
			result.append("field 'sex' must be filled\n");
		}
		if (member.getBirthday() == null) {
			result.append("field 'birthday' must be filled\n");
		}
		if (member.getPhone() == null) {
			result.append("field 'phone' must be filled\n");
		}
		return result;
	}
}
