package member.view;

import java.util.Scanner;

import member.model.dao.MemberManager;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberManager mManager = new MemberManager();

	public MemberMenu() {
	}

	public void mainMenu() {
		while (true) {
			System.out.println("***** 회원 관리 프로그램 *****");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 조회");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 정렬");
			System.out.println("5. 회원 삭제");
			System.out.println("6. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 선택 : ");

			switch (sc.nextInt()) {
			case 1:
				mManager.memberInput();
				break;
			case 2:
				searchMenu();
				break;
			case 3:
				modifyMenu();
				break;
			case 4: sortMenu();
			 		break;
			case 5:
				mManager.deleteMember();
				break;
			case 6:
				mManager.printAllMember();
				break;
			case 9:
				System.out.print("정말로 끝내시겠습니까? (y/n) : ");
				if (sc.next().toUpperCase().charAt(0) == 'Y')
					return;
				else
					continue;
			default:
				break;
			}
		}
	}

	public void searchMenu() {
		int index;
		while (true) {
			System.out.println("***** 회원 정보 검색 메뉴 *****");
			System.out.println("1. 아이디로 검색");
			System.out.println("2. 이름으로 검색");
			System.out.println("3. 이메일로 검색");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");

			switch (sc.nextInt()) {
			case 1:
				System.out.print("ID 입력 : ");
				index = mManager.searchMemberId(sc.next());
				if (index == -1) {
					System.out.println("없는 아이디 입니다.");
					break;
				}
				mManager.printMember(index);
				break;

			case 2:
				System.out.print("이름 입력 : ");
				index = mManager.searchMemberName(sc.next());
				if (index == -1) {
					System.out.println("없는 이름 입니다.");
					break;
				}
				mManager.printMember(index);
				break;
			case 3:
				System.out.print("이름 입력 : ");
				index = mManager.searchMemberEmail(sc.next());
				if (index == -1) {
					System.out.println("없는 E-mail 입니다.");
					break;
				}
				mManager.printMember(index);
				break;
			case 9:
				return;
			default:
				break;
			}
		}
	}
	public void sortMenu(){
		while(true){
		System.out.println("1. 아이디 오름차순 정렬 출력");
		System.out.println("2. 아이디 내림차순 정렬 출력");
		System.out.println("3. 나이 오름차순 정렬 출력");
		 System.out.println("4. 나이 내림차순 정렬 출력");
		 System.out.println("5. 성별 내림차순 정렬 출력(남여순)");
		 System.out.println("9. 이전 메뉴로 가기");
		 System.out.print("메뉴 선택 : ");
		
		 switch(sc.nextInt()){
		 case 1: mManager.sortIDAsc(); break;
		 case 2: mManager.sortIDDes(); break;
		 case 3: mManager.sortAgeAsc(); break;
		 case 4: mManager.sortAgeDes(); break;
		 case 5: mManager.sortGenderDes(); break;
		 case 9: System.out.println("메인 메뉴로 화면 이동합니다."); return;
		 default : break;
		 }
		 }

	}

	public void modifyMenu() {
		int index;

		while (true) {
			System.out.println("1. 암호 변경");
			System.out.println("2. 이메일 변경");
			System.out.println("3. 나이 변경");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");

			switch (sc.nextInt()) {
			case 1:
				System.out.print("ID 입력 : ");
				index = mManager.searchMemberId(sc.next());
				if (index == -1) {
					System.out.println("없는 아이디 입니다.");
					break;
				}
				mManager.printMember(index);
				mManager.member[index].setPassword(sc.next());
				break;

			case 2:
				System.out.print("이름 입력 : ");
				index = mManager.searchMemberName(sc.next());
				if (index == -1) {
					System.out.println("없는 이름 입니다.");
					break;
				}
				mManager.printMember(index);
				mManager.member[index].setEmail(sc.next());
				break;
			case 3:
				System.out.print("이름 입력 : ");
				index = mManager.searchMemberEmail(sc.next());
				if (index == -1) {
					System.out.println("없는 E-mail 입니다.");
					break;
				}
				mManager.printMember(index);
				mManager.member[index].setAge(sc.nextInt());
				break;
			case 9:
				return;
			default:
				continue;
			}
		}

	}
}
