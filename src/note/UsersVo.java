package note;

public class UsersVo {

	private int user_index;
	private String user_id;
	private String user_pw;
	
	public UsersVo() {}

	public UsersVo(int user_index, String user_id, String user_pw) {
		super();
		this.user_index = user_index;
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	public int getUser_index() {
		return user_index;
	}

	public UsersVo setUser_index(int user_index) {
		this.user_index = user_index;
		return this;
	}

	public String getUser_id() {
		return user_id;
	}

	public UsersVo setUser_id(String user_id) {
		this.user_id = user_id;
		return this;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public UsersVo setUser_pw(String user_pw) {
		this.user_pw = user_pw;
		return this;
	}
	
	
}
