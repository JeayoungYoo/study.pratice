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
			System.out.println("***** ȸ�� ���� ���α׷� *****");
			System.out.println("1. �� ȸ�� ���");
			System.out.println("2. ȸ�� ��ȸ");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ����");
			System.out.println("6. ��� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ���� : ");

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
				System.out.print("������ �����ðڽ��ϱ�? (y/n) : ");
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
			System.out.println("***** ȸ�� ���� �˻� �޴� *****");
			System.out.println("1. ���̵�� �˻�");
			System.out.println("2. �̸����� �˻�");
			System.out.println("3. �̸��Ϸ� �˻�");
			System.out.println("9. ���� �޴��� ����");
			System.out.print("�޴� ���� : ");

			switch (sc.nextInt()) {
			case 1:
				System.out.print("ID �Է� : ");
				index = mManager.searchMemberId(sc.next());
				if (index == -1) {
					System.out.println("���� ���̵� �Դϴ�.");
					break;
				}
				mManager.printMember(index);
				break;

			case 2:
				System.out.print("�̸� �Է� : ");
				index = mManager.searchMemberName(sc.next());
				if (index == -1) {
					System.out.println("���� �̸� �Դϴ�.");
					break;
				}
				mManager.printMember(index);
				break;
			case 3:
				System.out.print("�̸� �Է� : ");
				index = mManager.searchMemberEmail(sc.next());
				if (index == -1) {
					System.out.println("���� E-mail �Դϴ�.");
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
		System.out.println("1. ���̵� �������� ���� ���");
		System.out.println("2. ���̵� �������� ���� ���");
		System.out.println("3. ���� �������� ���� ���");
		 System.out.println("4. ���� �������� ���� ���");
		 System.out.println("5. ���� �������� ���� ���(������)");
		 System.out.println("9. ���� �޴��� ����");
		 System.out.print("�޴� ���� : ");
		
		 switch(sc.nextInt()){
		 case 1: mManager.sortIDAsc(); break;
		 case 2: mManager.sortIDDes(); break;
		 case 3: mManager.sortAgeAsc(); break;
		 case 4: mManager.sortAgeDes(); break;
		 case 5: mManager.sortGenderDes(); break;
		 case 9: System.out.println("���� �޴��� ȭ�� �̵��մϴ�."); return;
		 default : break;
		 }
		 }

	}

	public void modifyMenu() {
		int index;

		while (true) {
			System.out.println("1. ��ȣ ����");
			System.out.println("2. �̸��� ����");
			System.out.println("3. ���� ����");
			System.out.println("9. ���� �޴��� ����");
			System.out.print("�޴� ���� : ");

			switch (sc.nextInt()) {
			case 1:
				System.out.print("ID �Է� : ");
				index = mManager.searchMemberId(sc.next());
				if (index == -1) {
					System.out.println("���� ���̵� �Դϴ�.");
					break;
				}
				mManager.printMember(index);
				mManager.member[index].setPassword(sc.next());
				break;

			case 2:
				System.out.print("�̸� �Է� : ");
				index = mManager.searchMemberName(sc.next());
				if (index == -1) {
					System.out.println("���� �̸� �Դϴ�.");
					break;
				}
				mManager.printMember(index);
				mManager.member[index].setEmail(sc.next());
				break;
			case 3:
				System.out.print("�̸� �Է� : ");
				index = mManager.searchMemberEmail(sc.next());
				if (index == -1) {
					System.out.println("���� E-mail �Դϴ�.");
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
