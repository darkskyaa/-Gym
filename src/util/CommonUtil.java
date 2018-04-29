package util;

import inbody.pojo.InbodyBean;
import member.pojo.MemberBean;

public class CommonUtil {
	
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
	
	public static StringBuilder checkInbody(InbodyBean inbody, boolean idCheckRequired) {
		StringBuilder result = new StringBuilder();
		if (idCheckRequired && inbody.getId() == null) {
			result.append("field 'id' must be filled\n");
		}
		if (inbody.getWeight() == null) {
			result.append("field 'weight' must be filled\n");
		}
		if (inbody.getMuscleMass() == null) {
			result.append("field 'muscle mass' must be filled\n");
		}
		if (inbody.getTbw() == null) {
			result.append("field 'TBW' must be filled\n");
		}
		if (inbody.getProteins() == null) {
			result.append("field 'proteins' must be filled\n");
		}
		if (inbody.getMinerals() == null) {
			result.append("field 'minerals' must be filled\n");
		}
		if (inbody.getBoneContent() == null) {
			result.append("field 'bone content' must be filled\n");
		}
		if (inbody.getPbf() == null) {
			result.append("field 'PBF' must be filled\n");
		}
		if (inbody.getVfl() == null) {
			result.append("field 'VFL' must be filled\n");
		}
		if (inbody.getBmr() == null) {
			result.append("field 'BMR' must be filled\n");
		}
		return result;
	}
}
