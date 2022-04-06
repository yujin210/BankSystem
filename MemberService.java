package bankSystem0831;

import java.util.Scanner;

/*
 * 기준일자 : 2021.09.01
 * 은행시스템 적용한 기능
 	- 반복문, 조건문 적용
 	- 배열, 메서드 적용
 	- 객체 개념 적용
 	- 패키지 (08/31)
 	- Collection 적용? 
*/

public class MemberService {
	// 멤버 변수 영역 (필드) : 멤버 변수 메모리 저장 영역은 힙 or 스택?
	Scanner in = new Scanner(System.in);
	
	public Member[] member  = new Member[100]; // Member 클래스 객체 member 선언 (public 뭐지? 다른 클래스에서 접근 가능?)
	String name;
	String id;
	String pw;
	int memberNum;
	
	public MemberService() { // 회원가입 (근데 왜 MemberService 생성자에다가 member 객체 생성하는 것을 적어주는거지? 위치 궁금...)
		// MemberService객체 생성시 생성자가 시작 되어서 그런 것인가?
		
		for(int i = 0; i < member.length; i++) {
			System.out.print("이름 : ");
			name = in.next();
			System.out.print("ID : ");
			id = in.next();
			System.out.print("PW : ");
			pw = in.next();
			
			member[i] = new Member(name, id, pw); // 입력 받은 값을 바탕으로 member 생성자에 값을 넣어 회원가입
		} // end for문
	} // 회원가입 메서드 끝
	
	
	public boolean login(int memberNum, String id, String pw) { // 로그인 메서드
		boolean result = false;
		this.memberNum = memberNum;
		this.id = id;
		this.pw = pw;
		
		if (id.equals(member[memberNum-1].getId()) && pw.equals(member[memberNum-1].getPw())) {
			System.out.println(member[memberNum-1].getName() + "님 로그인 환영합니다.");
			result = true;
			return result;
		} else {
			result = false;
			return result;
		}
	} // 로그인 메서드 끝
	
	public void logout() { // 입력 값을 아이디로 받는게 맞나? (일단 입력 x)
		System.out.println("로그아웃 되었습니다.");
	}

}
