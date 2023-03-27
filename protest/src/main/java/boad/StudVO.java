package boad;



public class StudVO {
	private String id;
	private String username;
	private String univ;
	private String birth;
	private String email;
	
	
	public StudVO() {
		System.out.println("StudVO 생성자 호출");
	}
	
	public StudVO(String id, String email, String username, String birth, String univ) {
		this.id = id;
		this.birth = birth;
		this.username = username;
		this.email = email;
		this.setUniv(univ);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return birth;
	}

	public void setPwd(String pwd) {
		this.birth = pwd;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName1() {
		return birth;
	}

	public void setName1(String name1) {
		this.birth = name1;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}


	
	
	
	
}
