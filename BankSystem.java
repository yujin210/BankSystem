package bankSystem0831;

import java.util.Scanner;

/*
 * 기준일자 : 2021.09.01
 * 은행시스템 적용할 기능
 	- 반복문, 조건문 적용 : 완료 
 	- 배열, 메서드 적용 : 완료
 	- 객체 개념 적용
 	- 패키지 (08/31)
 	- 배열을 ArrayList로 교체 (09/01) 
*/

public class BankSystem {
	// 멤버 변수 영역 (필드)
	Scanner in = new Scanner(System.in);
	boolean run;
	String id;
	String pw;
	String name;
	int check;
	int memberNum;
	int balance;
	
	public Member[] member; // Member 클래스 객체 member 선언 (초기화 x)
	
	
	public BankSystem() {
		run = true;
	}
	
	
	public static void main(String[] args) {
		new BankSystem().loginMenu(); // 로그인 메뉴 시작

	}
	
	// 초기 진입 (로그인, 회원가입, 종료)
	public void loginMenu() {
		System.out.println("테스트 : 로그인 메뉴");
		
	}
	
	// 로그인 후 화면 (회원조회, 예금, 출금, 잔고, 종료)
	public void selectMenu() {
		
	}
	
	
	// 잔고 확인 메서드  -> getBalance로 가져오면 되니까 필요 없나?
	
	
	// 예금 메서드
	public int deposit() {
		return 1; // 지우기 
	}
	
	// 출금 메서드
	public int withdraw() {
		return 1;
	}

}
