package infoSystem;

public class UserAccountDataBase {
	// implementing Singleton Class
	private static UserAccountDataBase userDatabase = null;
	private User[] userAccount;

	public static UserAccountDataBase getInstance() {
		if (userDatabase == null) {
			userDatabase = new UserAccountDataBase();
		}
		return userDatabase;
	}

	UserAccountDataBase() {
		String[] nameAry = new String[] { "Harry", "Ross", "Bruce", "Cook", "Carolyn", "Morgan", "Albert", "Walker",
				"Randy", "Reed", "Larry", "Barnes", "Lois", "Wilson", "Jesse", "Campbell", "Ernest", "Rogers",
				"Theresa", "Patterson", "Henry", "Simmons", "Michelle", "Perry", "Frank", "Butler", "Shirley", "Paula",
				"Phillips", "Annie" };
		char[] passwordAry = "user1234".toCharArray();
		String[] genderAry = new String[] { "Male", "Female" };
		String[] phoneNumAry = new String[] { "0989147223", "0242425677", "0348471445" };

		int size = nameAry.length;
		userAccount = new User[size];
		for (int i = 0; i < size; i++) {
			String userName = nameAry[i];
			char[] password = passwordAry;
			String gender = genderAry[i % genderAry.length];
			String email = new String(nameAry[i] + "@gmail.com");
			String phoneNum = phoneNumAry[i % phoneNumAry.length];
			userAccount[i] = new User(userName, password, gender, email, phoneNum);
		}

	}

	public User[] getUserAccountAry() {
		return userAccount;
	}

}
