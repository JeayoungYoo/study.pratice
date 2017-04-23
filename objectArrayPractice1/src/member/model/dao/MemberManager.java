package member.model.dao;

import java.util.Scanner;

import member.model.dto.Member;

public class MemberManager {
	
	public final int SIZE = 10;
	public Member[] member;
	public int cnt=0;
	Member temp = new Member();
	
	Scanner sc;
	
			
	public MemberManager () {
	      member = new Member[SIZE];
	      sc = new Scanner(System.in);
	}
	
	public void memberInput() {
		System.out.println("���� ��ϵ� ȸ������ "+cnt+"�� �Դϴ�.");
		
		if (cnt<SIZE){
			member[cnt]= new Member();
			System.out.print("id �Է� : ");
			member[cnt].setId(sc.next());
			System.out.print("�̸� �Է� : ");
			member[cnt].setName(sc.next());
			System.out.println("password �Է� : ");
			member[cnt].setPassword(sc.next());
			System.out.print("E-mail �Է� : ");
			member[cnt].setEmail(sc.next());
			System.out.print("���� �Է� (m/f) : ");
			member[cnt].setGender(sc.next().toUpperCase().charAt(0));
			System.out.print("���� �Է� : ");
			member[cnt].setAge(sc.nextInt());
			
			cnt++;
		}
		else
			System.out.println("�ִ� ��� ������ ȸ�� ���� "+SIZE+"�� �Դϴ�.");
		
		
	}
	
	public void deleteMember() {
		String input;
		System.out.print("�����Ͻ� ID : ");
		input = sc.next();
		for (int i = 0; i < cnt; i++) {
			if (member[i].getId().equals(input)){
				for (int j=i; j<cnt-1; j++)
					member[j] = member[j+1];
				break;
				
			}
			
		}
		cnt--;
	}
	public void printAllMember() {
		
		for (int i=0; i<cnt; i++){
			System.out.println(member[i].memberInfo());
		}
	}

	public int searchMemberId(String id) {
		int index = -1;
		for (int i=0; i<cnt; i++){
			if(member[i].getId().equals(id)){
				index = i;
				break;
			}
		}
		return index;
	}

	public int searchMemberName(String name) {
		int index = -1;
		for (int i=0; i<cnt; i++){
			if (member[i].getName().equals(name)){
				index = i;
				break;
			}
		}
		
		return index;
	}

	public int searchMemberEmail(String email) {
		int index = -1;
		for (int i=0; i<cnt; i++){
			if (member[i].getName().equals(email)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void printMember(int index) {
		System.out.println(member[index].memberInfo());
	}

	public void sortIDAsc() {
		//���̵� ��������
		for (int i=0; i<cnt-1; i++){
			for(int j=i+1; j<cnt; j++)
				if(member[i].getId().compareTo(member[j].getId())>0){
					temp = member[i];
					member[i] = member[j];
					member[j] = temp;
				}
		}
	}

	public void sortIDDes() {
		//���̵� ��������
		for (int i=0; i<cnt-1; i++){
			for(int j=i+1; j<cnt; j++)
				if(member[i].getId().compareTo(member[j].getId())<0){
					temp = member[i];
					member[i] = member[j];
					member[j] = temp;
				}
		}
		
	}

	public void sortAgeAsc() {
		//���� ��������
		for (int i=0; i<cnt-1; i++){
			for(int j=i+1; j<cnt; j++)
				if(member[i].getAge()>member[j].getAge()){
					temp = member[i];
					member[i] = member[j];
					member[j] = temp;
				}
		}
		
	}

	public void sortAgeDes() {
		for (int i=0; i<cnt-1; i++){
			for(int j=i+1; j<cnt; j++)
				if(member[i].getAge()<member[j].getAge()){
					temp = member[i];
					member[i] = member[j];
					member[j] = temp;
				}
		}		
		
	}

	public void sortGenderDes() {
		for (int i=0; i<cnt-1; i++){
			for(int j=i+1; j<cnt; j++)
				if(member[i].getGender()<member[j].getGender()){
					temp = member[i];
					member[i] = member[j];
					member[j] = temp;
				}
		}
		
	}

//	private void swap(int[] member, int i, int j) {
//		int temp = member[i];
//		member[i] = member[j];
//		member[j] = temp;
//	}
	}