package bankSystem0831;

/*
* 기준일자 : 2021.09.01
 * 은행시스템 적용할 기능
 	- 반복문, 조건문 적용 : 완료 
 	- 배열, 메서드 적용 : 완료
 	- 객체 개념 적용
 	- 패키지 (08/31)
 	- 배열을 ArrayList로 교체 (09/01) 
*/

public class Member { //!! getter, setter 사용 시에는 멤버 변수를 private로 해주자!
	private static int MEMBER_NO = 0;
	private String name; // 사용자 이름
	private String id; // 사용자 아이디
	private String pw; // 사용자 비밀번호
	private String grade; // 사용자 등급
	private int memberNo = 0; // 사용자 번호 (계좌번호 아님)
	private int balance; // 사용자 잔고
	
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Member() {} // 스프링용 기본 생성자
	
	public Member(String name, String id, String pw) { // 회원가입시 사용하는 생성자
		this.memberNo = ++MEMBER_NO;
		this.name = name;
		this.id  = id;
		this.pw = pw;
		this.grade = "welcome";
//		memberNo = ++memberNo; // 멤버 번호는 이렇게 해주면 자동으로 증가하나? (초기값 : 0)
		this.balance = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void showInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("ID : " + getId());
		System.out.println("PW : " + getPw());
		System.out.println("등급 : " + getGrade());
		System.out.println("잔고 : " + getBalance());
	}
	
}
