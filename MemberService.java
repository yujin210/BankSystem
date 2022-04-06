package bankSystem0831;

import java.util.Scanner;

/*
 * �������� : 2021.09.01
 * ����ý��� ������ ���
 	- �ݺ���, ���ǹ� ����
 	- �迭, �޼��� ����
 	- ��ü ���� ����
 	- ��Ű�� (08/31)
 	- Collection ����? 
*/

public class MemberService {
	// ��� ���� ���� (�ʵ�) : ��� ���� �޸� ���� ������ �� or ����?
	Scanner in = new Scanner(System.in);
	
	public Member[] member  = new Member[100]; // Member Ŭ���� ��ü member ���� (public ����? �ٸ� Ŭ�������� ���� ����?)
	String name;
	String id;
	String pw;
	int memberNum;
	
	public MemberService() { // ȸ������ (�ٵ� �� MemberService �����ڿ��ٰ� member ��ü �����ϴ� ���� �����ִ°���? ��ġ �ñ�...)
		// MemberService��ü ������ �����ڰ� ���� �Ǿ �׷� ���ΰ�?
		
		for(int i = 0; i < member.length; i++) {
			System.out.print("�̸� : ");
			name = in.next();
			System.out.print("ID : ");
			id = in.next();
			System.out.print("PW : ");
			pw = in.next();
			
			member[i] = new Member(name, id, pw); // �Է� ���� ���� �������� member �����ڿ� ���� �־� ȸ������
		} // end for��
	} // ȸ������ �޼��� ��
	
	
	public boolean login(int memberNum, String id, String pw) { // �α��� �޼���
		boolean result = false;
		this.memberNum = memberNum;
		this.id = id;
		this.pw = pw;
		
		if (id.equals(member[memberNum-1].getId()) && pw.equals(member[memberNum-1].getPw())) {
			System.out.println(member[memberNum-1].getName() + "�� �α��� ȯ���մϴ�.");
			result = true;
			return result;
		} else {
			result = false;
			return result;
		}
	} // �α��� �޼��� ��
	
	public void logout() { // �Է� ���� ���̵�� �޴°� �³�? (�ϴ� �Է� x)
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}

}
