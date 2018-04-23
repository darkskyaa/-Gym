package core.pojo;

import java.io.Serializable;
import java.lang.reflect.Field;

public class CoreBean implements Serializable {
	private String creator;
	private String createdDatetime;
	private String modifier;
	private String modifiedDatetime;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(String modifiedDatetime) {
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
