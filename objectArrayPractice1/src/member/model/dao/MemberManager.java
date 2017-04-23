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
		System.out.println("현재 등록된 회원수는 "+cnt+"명 입니다.");
		
		if (cnt<SIZE){
			member[cnt]= new Member();
			System.out.print("id 입력 : ");
			member[cnt].setId(sc.next());
			System.out.print("이름 입력 : ");
			member[cnt].setName(sc.next());
			System.out.println("password 입력 : ");
			member[cnt].setPassword(sc.next());
			System.out.print("E-mail 입력 : ");
			member[cnt].setEmail(sc.next());
			System.out.print("성별 입력 (m/f) : ");
			member[cnt].setGender(sc.next().toUpperCase().charAt(0));
			System.out.print("나이 입력 : ");
			member[cnt].setAge(sc.nextInt());
			
			cnt++;
		}
		else
			System.out.println("최대 등록 가능한 회원 수는 "+SIZE+"명 입니다.");
		
		
	}
	
	public void deleteMember() {
		String input;
		System.out.print("삭제하실 ID : ");
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
		//아이디 오름차순
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
		//아이디 내림차순
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
		//나이 오름차순
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