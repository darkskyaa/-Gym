package core.pojo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;

public class CoreBean implements Serializable {
	private String creator;
	private Timestamp createdDatetime;
	private String modifier;
	private Timestamp modifiedDatetime;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}
	
	public void showContent() {
		StringBuilder result = new StringBuilder("[");
		String property;
		Object value;
		for (Field field : getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);//設定可存取私有(private)屬性
				property = field.getName();
				value = field.get(this);
				result.append(property + " : " + value + ", ");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		result.delete(result.length() - 2, result.length());
		result.append("]");
		System.out.println(result);
	}
}
