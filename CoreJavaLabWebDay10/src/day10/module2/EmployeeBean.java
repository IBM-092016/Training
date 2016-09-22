package day10.module2;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mId;
	private String mName;
	private int mAge;

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public int getAge() {
		return mAge;
	}

	public void setAge(int age) {
		mAge = age;
	}
}
