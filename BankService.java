package bankSystem0831;

import java.util.Scanner;

// 필요한 메서드 만들기
public class BankService {
	Scanner sc = new Scanner(System.in);
	Member[] members = new Member[10]; // 객체를 담을 배열 (객체 "보관") => 회원 가입 한 객체를 저장할 객체배열
	// [미션] => ArrayList 사용해서 바꿔보기 => 초기화 할 필요 없음
	Member session = new Member();
	
	
	public void selectMenu() {
		// 객체배열 초기화 -> 초기화 안하면 nullPointerException 발생함
		for (int i = 0; i < members.length; i++) {
			members[i] = new Member();
		}

		boolean run = true;
		boolean firstConnect = true; // 초기 진입 여부 확인
		
		while (run) {
			if (firstConnect) {
				System.out.println("-----------------------");
				System.out.println("1.가입 | 2. 로그인 | 3. 종료");
				System.out.println("-----------------------");
				System.out.print("선택 > ");
				int num = sc.nextInt(); // 메뉴 번호 선택

				switch (num) {
				case 1:
					System.out.println("1. 가입 ");
					register();
					break;

				case 2:
					System.out.println("2. 로그인 ");
					if (login()) {
						firstConnect = false;
						
					}
					break;
//					login(); // login 메서드에서 반환한 member가 들어옴
//					System.out.println(session.getId());
//					System.out.println(session.getPw());
//					System.out.println(session.getName());
//					if (session != null) { 
//						 // 로그인 되면 두 번째 화면으로
//					}
					

				case 3:
					// 재실행 할 필요 없도록
					System.out.println("3. 종료 ");
					break;
				}

			} else {
				System.out.println("------------------------------------");
				System.out.println("1.입금 | 2.출금 | 3. 계좌조회 | 4. 로그아웃");
				System.out.println("------------------------------------");
				System.out.print("선택 > ");
				int num = sc.nextInt();
				
				switch (num) {
					case 1 :
						System.out.println(session.getBalance()); // 입금 전
						deposit();
						System.out.println(session.getBalance()); // 입금 후 -> 입금 전 + 입금 받은 금액
						break;
						
					case 2 : 
						System.out.println("출금 전 : " + session.getBalance());
						withdrawal();
						System.out.println("출금 후 : " + session.getBalance());
						break;
						
					case 3 : 
						checkBalance();
						break;
						
					case 4 : 
						firstConnect = true; // 처음화면으로 돌아가기
						break;
						
					default : 
						
				}
				
			}
		}

	}

	void checkBalance() { // 계좌 조회 (잔고 확인)
		System.out.println("잔고 : " + session.getBalance());
	}

	void withdrawal() {
		// 출금 관련 코드
		
		int balance = session.getBalance(); // 현재 잔고
		System.out.print("출금 금액 : "); 
		int money = sc.nextInt(); // 출금 금액
		if (balance >= money) { // 출금하고자 하는 금액이 잔고보다 적을 때 => 출금 가능
			session.setBalance(balance - money); // (현재 잔고 - 출금 금액)를 다시 계좌 정보에 저장
		} else { 
			System.out.println("잔액이 부족합니다."); // 출금하고자 하는 금액이 잔고보다 많을 때 => 출금 불가
		}
		
	}

	void deposit() {
		// 입금 관련 코드
		int balance = session.getBalance(); // 현재 잔고 정보 가져오기
		System.out.print("입금 금액 : ");
		int money = sc.nextInt();
		session.setBalance(balance + money);
	}

	boolean login() { //로그인한 Member 객체 반환받아서 계좌정보가 유지될 수 있도록 해보기.
		
//		Member member = new Member(); // 리턴 할 객체 -> 로그인 정보 (아이디, 비밀번호, 이름, 계좌)
		String id = "";
		String pw = "";
		boolean loginSuccess = false;
		boolean idCheck = false; // 배열 내에 로그인하려는 아이디가 있는지 확인하기 위한 변수

		while (!idCheck) {
			System.out.print("아이디 : ");
			id = sc.next();
			for (int i = 0; i < members.length; i++) {
				if (members[i].getId() != null && members[i].getId().equals(id)) { // nullPointerException방지
					idCheck = true; // members 배열에 로그인 하려는 아이디가 존재함
					while (!loginSuccess) {
						System.out.print("비밀번호 : ");
					pw = sc.next();
					if (members[i].getPw().equals(pw)) {
						loginSuccess = true; // 로그인 하려는 아이디와 비밀번호가 배열 안에 존재함
						session = members[i];
						
						System.out.println("로그인 성공");
						break;
					} else {
						System.out.println("비밀번호를 확인하세요.");
					} // 비밀번호 검사 종료
				} 
			}
					
		} // for문 종료

			if (!idCheck) { // idCheck == false로 값을 넣어도 됨.
				System.out.println("아이디를 확인하세요.");
			} else {
				break;
			}
			
			
		}
		return loginSuccess;
//		return member;
		

//		// loginSuccess는 true인 상태 -> member변수에 members[i]가 담긴 상태
//		if (loginSuccess) { // true
//			return 1;
//		} else { // false
//			return -1;
//		}
	}

	void register() { // 회원가입 메서드
		System.out.print("아이디 : ");
		String id = sc.next();// sc = new Scanner(System.in); 은 초기화
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();

		Member member = new Member(name, id, pw); // 회원가입하는 객체 생성 -> members에 저장
//		System.out.println(member.getMemberNo());
//		System.out.println(member.getId());
//		System.out.println(member.getPw());
//		System.out.println(member.getName());

		// 배열에 저장하는 방법 1
//		int cnt = 0;
//		members[cnt++] = member;

		// 배열에 저장하는 방법 2

//		System.out.println("번호 : " + member.getMemberNo());
		members[member.getMemberNo() - 1] = member;
		// 보통 회원 번호 등은 1부터 시작하고, 인덱스는 0부터 시작하므로 1을 빼준다.

		System.out.println(members[member.getMemberNo() - 1].getMemberNo());
		System.out.println(members[member.getMemberNo() - 1].getId());
		System.out.println(members[member.getMemberNo() - 1].getPw());
		System.out.println(members[member.getMemberNo() - 1].getName());

	}

}
