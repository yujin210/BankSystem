package bankSystem0831;

import java.util.Scanner;

/*
 * �������� : 2021.09.01
 * ����ý��� ������ ���
 	- �ݺ���, ���ǹ� ���� : �Ϸ� 
 	- �迭, �޼��� ���� : �Ϸ�
 	- ��ü ���� ����
 	- ��Ű�� (08/31)
 	- �迭�� ArrayList�� ��ü (09/01) 
*/

public class BankSystem {
	// ��� ���� ���� (�ʵ�)
	Scanner in = new Scanner(System.in);
	boolean run;
	String id;
	String pw;
	String name;
	int check;
	int memberNum;
	int balance;
	
	public Member[] member; // Member Ŭ���� ��ü member ���� (�ʱ�ȭ x)
	
	
	public BankSystem() {
		run = true;
	}
	
	
	public static void main(String[] args) {
		new BankSystem().loginMenu(); // �α��� �޴� ����

	}
	
	// �ʱ� ���� (�α���, ȸ������, ����)
	public void loginMenu() {
		System.out.println("�׽�Ʈ : �α��� �޴�");
		
	}
	
	// �α��� �� ȭ�� (ȸ����ȸ, ����, ���, �ܰ�, ����)
	public void selectMenu() {
		
	}
	
	
	// �ܰ� Ȯ�� �޼���  -> getBalance�� �������� �Ǵϱ� �ʿ� ����?
	
	
	// ���� �޼���
	public int deposit() {
		return 1; // ����� 
	}
	
	// ��� �޼���
	public int withdraw() {
		return 1;
	}

}
