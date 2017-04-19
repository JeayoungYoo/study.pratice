package member.model.vo;

import java.util.Arrays;
import java.util.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private int age;
	private char gender;
	private Date birth;
	private String email;
	private String mobile;
	private String[] hobby;
	
	public Member(){}

	public Member(String id, String password, String name) {
		
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public Member(String id, String password, String name, int age, char gender) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Member(String id, String password, String name, int age, char gender, Date birth, String email,
			String mobile, String[] hobby) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.mobile = mobile;
		this.hobby = hobby;
	}
/*	public void sethobby(){
		
	}*/
	
	Date date = new Date();
	
	public void information(){
		
		System.out.println(this.id + "\t" + this.password + "\t" + this.name + "\t" + this.age + "\t" + this.gender + "\t" + birth + "\t" + this.email + "\t" + this.mobile + "\t" + Arrays.toString(hobby));
//		return;  void일경우 리턴 생략가능
	}

/*	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", birth=" + birth + ", email=" + email + ", mobile=" + mobile + ", hobby=" + Arrays.toString(hobby)
				+ "]";
	}*/
	
}
