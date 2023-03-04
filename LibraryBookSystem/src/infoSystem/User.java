package infoSystem;

public class User {
	private String userName;
	private char[] password;
	private String gender;
	private String email;
	private String phoneNum;

	private static String admin = "admin";
	private static char[] adminPassword = "admin1234".toCharArray();

	public User(String userName, char[] password, String gender, String email, String phoneNum) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.phoneNum = phoneNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	// Temporary method for the purpose of demo
	public static String getAdminName() {
		return admin;

	}

	// Temporary method for the purpose of demo
	public static char[] getAdminPassword() {
		return adminPassword;
	}
}
