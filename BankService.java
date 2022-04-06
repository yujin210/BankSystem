package bankSystem0831;

import java.util.Scanner;

// �ʿ��� �޼��� �����
public class BankService {
	Scanner sc = new Scanner(System.in);
	Member[] members = new Member[10]; // ��ü�� ���� �迭 (��ü "����") => ȸ�� ���� �� ��ü�� ������ ��ü�迭
	// [�̼�] => ArrayList ����ؼ� �ٲ㺸�� => �ʱ�ȭ �� �ʿ� ����
	Member session = new Member();
	
	
	public void selectMenu() {
		// ��ü�迭 �ʱ�ȭ -> �ʱ�ȭ ���ϸ� nullPointerException �߻���
		for (int i = 0; i < members.length; i++) {
			members[i] = new Member();
		}

		boolean run = true;
		boolean firstConnect = true; // �ʱ� ���� ���� Ȯ��
		
		while (run) {
			if (firstConnect) {
				System.out.println("-----------------------");
				System.out.println("1.���� | 2. �α��� | 3. ����");
				System.out.println("-----------------------");
				System.out.print("���� > ");
				int num = sc.nextInt(); // �޴� ��ȣ ����

				switch (num) {
				case 1:
					System.out.println("1. ���� ");
					register();
					break;

				case 2:
					System.out.println("2. �α��� ");
					if (login()) {
						firstConnect = false;
						
					}
					break;
//					login(); // login �޼��忡�� ��ȯ�� member�� ����
//					System.out.println(session.getId());
//					System.out.println(session.getPw());
//					System.out.println(session.getName());
//					if (session != null) { 
//						 // �α��� �Ǹ� �� ��° ȭ������
//					}
					

				case 3:
					// ����� �� �ʿ� ������
					System.out.println("3. ���� ");
					break;
				}

			} else {
				System.out.println("------------------------------------");
				System.out.println("1.�Ա� | 2.��� | 3. ������ȸ | 4. �α׾ƿ�");
				System.out.println("------------------------------------");
				System.out.print("���� > ");
				int num = sc.nextInt();
				
				switch (num) {
					case 1 :
						System.out.println(session.getBalance()); // �Ա� ��
						deposit();
						System.out.println(session.getBalance()); // �Ա� �� -> �Ա� �� + �Ա� ���� �ݾ�
						break;
						
					case 2 : 
						System.out.println("��� �� : " + session.getBalance());
						withdrawal();
						System.out.println("��� �� : " + session.getBalance());
						break;
						
					case 3 : 
						checkBalance();
						break;
						
					case 4 : 
						firstConnect = true; // ó��ȭ������ ���ư���
						break;
						
					default : 
						
				}
				
			}
		}

	}

	void checkBalance() { // ���� ��ȸ (�ܰ� Ȯ��)
		System.out.println("�ܰ� : " + session.getBalance());
	}

	void withdrawal() {
		// ��� ���� �ڵ�
		
		int balance = session.getBalance(); // ���� �ܰ�
		System.out.print("��� �ݾ� : "); 
		int money = sc.nextInt(); // ��� �ݾ�
		if (balance >= money) { // ����ϰ��� �ϴ� �ݾ��� �ܰ��� ���� �� => ��� ����
			session.setBalance(balance - money); // (���� �ܰ� - ��� �ݾ�)�� �ٽ� ���� ������ ����
		} else { 
			System.out.println("�ܾ��� �����մϴ�."); // ����ϰ��� �ϴ� �ݾ��� �ܰ��� ���� �� => ��� �Ұ�
		}
		
	}

	void deposit() {
		// �Ա� ���� �ڵ�
		int balance = session.getBalance(); // ���� �ܰ� ���� ��������
		System.out.print("�Ա� �ݾ� : ");
		int money = sc.nextInt();
		session.setBalance(balance + money);
	}

	boolean login() { //�α����� Member ��ü ��ȯ�޾Ƽ� ���������� ������ �� �ֵ��� �غ���.
		
//		Member member = new Member(); // ���� �� ��ü -> �α��� ���� (���̵�, ��й�ȣ, �̸�, ����)
		String id = "";
		String pw = "";
		boolean loginSuccess = false;
		boolean idCheck = false; // �迭 ���� �α����Ϸ��� ���̵� �ִ��� Ȯ���ϱ� ���� ����

		while (!idCheck) {
			System.out.print("���̵� : ");
			id = sc.next();
			for (int i = 0; i < members.length; i++) {
				if (members[i].getId() != null && members[i].getId().equals(id)) { // nullPointerException����
					idCheck = true; // members �迭�� �α��� �Ϸ��� ���̵� ������
					while (!loginSuccess) {
						System.out.print("��й�ȣ : ");
					pw = sc.next();
					if (members[i].getPw().equals(pw)) {
						loginSuccess = true; // �α��� �Ϸ��� ���̵�� ��й�ȣ�� �迭 �ȿ� ������
						session = members[i];
						
						System.out.println("�α��� ����");
						break;
					} else {
						System.out.println("��й�ȣ�� Ȯ���ϼ���.");
					} // ��й�ȣ �˻� ����
				} 
			}
					
		} // for�� ����

			if (!idCheck) { // idCheck == false�� ���� �־ ��.
				System.out.println("���̵� Ȯ���ϼ���.");
			} else {
				break;
			}
			
			
		}
		return loginSuccess;
//		return member;
		

//		// loginSuccess�� true�� ���� -> member������ members[i]�� ��� ����
//		if (loginSuccess) { // true
//			return 1;
//		} else { // false
//			return -1;
//		}
	}

	void register() { // ȸ������ �޼���
		System.out.print("���̵� : ");
		String id = sc.next();// sc = new Scanner(System.in); �� �ʱ�ȭ
		System.out.print("��й�ȣ : ");
		String pw = sc.next();
		System.out.print("�̸� : ");
		String name = sc.next();

		Member member = new Member(name, id, pw); // ȸ�������ϴ� ��ü ���� -> members�� ����
//		System.out.println(member.getMemberNo());
//		System.out.println(member.getId());
//		System.out.println(member.getPw());
//		System.out.println(member.getName());

		// �迭�� �����ϴ� ��� 1
//		int cnt = 0;
//		members[cnt++] = member;

		// �迭�� �����ϴ� ��� 2

//		System.out.println("��ȣ : " + member.getMemberNo());
		members[member.getMemberNo() - 1] = member;
		// ���� ȸ�� ��ȣ ���� 1���� �����ϰ�, �ε����� 0���� �����ϹǷ� 1�� ���ش�.

		System.out.println(members[member.getMemberNo() - 1].getMemberNo());
		System.out.println(members[member.getMemberNo() - 1].getId());
		System.out.println(members[member.getMemberNo() - 1].getPw());
		System.out.println(members[member.getMemberNo() - 1].getName());

	}

}
