package bankSystem0831;

/*
* �������� : 2021.09.01
 * ����ý��� ������ ���
 	- �ݺ���, ���ǹ� ���� : �Ϸ� 
 	- �迭, �޼��� ���� : �Ϸ�
 	- ��ü ���� ����
 	- ��Ű�� (08/31)
 	- �迭�� ArrayList�� ��ü (09/01) 
*/

public class Member { //!! getter, setter ��� �ÿ��� ��� ������ private�� ������!
	private static int MEMBER_NO = 0;
	private String name; // ����� �̸�
	private String id; // ����� ���̵�
	private String pw; // ����� ��й�ȣ
	private String grade; // ����� ���
	private int memberNo = 0; // ����� ��ȣ (���¹�ȣ �ƴ�)
	private int balance; // ����� �ܰ�
	
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Member() {} // �������� �⺻ ������
	
	public Member(String name, String id, String pw) { // ȸ�����Խ� ����ϴ� ������
		this.memberNo = ++MEMBER_NO;
		this.name = name;
		this.id  = id;
		this.pw = pw;
		this.grade = "welcome";
//		memberNo = ++memberNo; // ��� ��ȣ�� �̷��� ���ָ� �ڵ����� �����ϳ�? (�ʱⰪ : 0)
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
		System.out.println("�̸� : " + getName());
		System.out.println("ID : " + getId());
		System.out.println("PW : " + getPw());
		System.out.println("��� : " + getGrade());
		System.out.println("�ܰ� : " + getBalance());
	}
	
}
