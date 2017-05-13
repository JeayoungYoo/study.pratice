package board.controller;

import java.io.*;
import java.util.*;
import board.model.vo.*;


public class BoardManager {
	ArrayList<Board> list = new ArrayList<Board>();
	Scanner sc = new Scanner(System.in);
	private int num=0, index;

	public BoardManager() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("board_list.dat"))) {
			while (true){
				list.add((Board) ois.readObject());
				num++;
			}
		} catch (EOFException e) {
			System.out.println("리스트 저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		// >> 구현내용 : board_list.dat 파일의 내용을 읽어서
		// list에 저장함
		// null 될 때까지 저장함

	// 1. 게시글 쓰기 메소드
	public void writeBoard() {
		String title, writer;
		StringBuilder contents = new StringBuilder();
		Date date = new Date();
		
		// >> 구현내용
		// 1> "새 게시글 쓰기 입니다." 출력
		// 2> "글제목 : " >> 입력받음(공백포함)
		// 3> "작성자 : " >> 이름 입력받음 (공백없이)
		// 4> 작성날짜는 현재 날짜로 입력처리함
		// 5> "글내용 : " >> 여러 줄로 입력받음
		// "exit" 입력하면 입력종료
		// 6> Board 객체 생성시 초기값으로 사용함
		// 7> list에 추가함
		System.out.println("새 게시글 쓰기 입니다.");
		System.out.println("-----------------------------");
		System.out.print("글제목 : ");
		title = sc.nextLine()+sc.nextLine();
		System.out.print("작성자 : ");
		writer = sc.next();
		System.out.print("글내용 : ");
		while(true){
			String str = sc.nextLine();
			if (str.equals("exit")){
				System.out.println("글쓰기를 종료합니다");
				break;
			}
			contents.append(str + "\n");
		}
		list.add(new Board(num, title, writer, date, contents.toString(), 0));
		num++;

	}

	// 2. 게시글 전체 보기 메소드
	public void displayAllList() {
		// >> 구현내용
		// 1> list 에 기록된 정보를 모두 화면에 출력시킴
		for (int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}

	// 3. 게시글 한개 보기 메소드
	public void displayBoard() {
		// >> 구현내용
		// 1> "조회할 글번호 : " >> 입력받음
		// 2> 해당 글번호에 대한 게시글을 화면에 출력시킴
		// 3> 해당 글에 대한 조회수 1증가 처리함
		System.out.print("조회할 글번호 : ");
		index = sc.nextInt();
		list.get(index).setReadCount(list.get(index).getReadCount()+1);
		System.out.println(list.get(index));
		

	}

	// 4. 게시글 제목 수정 메소드
	public void modifyTitle() {
		// >> 구현내용
		// 1> "수정할 글번호 : " >> 입력받음
		// 2> 해당 글번호에 대한 게시글을 화면에 출력시킴
		// 3> "변경할 제목 : " >> 새 제목 입력받음 >> 제목변경
		// 4> 변경된 객체 정보를 list의 해당 번호 객체에 적용함
		System.out.print("수정할 글번호 : ");
		index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("변경할 제목 : ");
		list.get(index).setBoardTitle(sc.nextLine()+sc.nextLine());
		// 4> 확인 필요

	}

	// 5. 게시글 내용 수정 메소드
	public void modifyContent() {
		// >> 구현내용
		// 1> "수정할 글번호 : " >> 입력받음
		// 2> 해당 글번호에 대한 게시글을 화면에 출력시킴
		// 3> "변경할 내용 : " >> 새 내용 입력받음 >> 내용변경
		// 4> 변경된 객체 정보를 list의 해당 번호 객체에 적용함
		StringBuilder sb = new StringBuilder();
		
		System.out.print("수정할 글번호 : ");
		index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("변경할 내용 : ");
		while(true){
			String str = sc.nextLine();
			if (str.equals("exit")){
				System.out.println("글쓰기를 종료합니다");
				break;
			}
			sb.append(str + "\n");
		}
		list.get(index).setBoardContent(sb.toString());
		// 이것도 4번 확인 필요

	}

	// 6. 게시글 삭제 메소드
	public void deleteBoard() {
		// >> 구현내용
		// 1> "삭제할 글번호 : " >> 입력받음
		// 2> 해당 글번호에 대한 게시글을 화면에 출력시킴
		// 3> "정말로 삭제하시겠습니까? (y/n) : "
		System.out.print("삭제할 글번호 : ");
		index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("정말로 삭제하시겠습니까? (y/n) : ");
		if (sc.next().toUpperCase().charAt(0) == 'y'){
			list.remove(index);
			System.out.println("삭제 완료");
		}
	}

	// 7. 게시글 검색 메소드
	public void searchBoard() {
		// >> 구현내용
		// 1> "검색할 제목 : " >> 검색할 글자를 입력받음
		// 2> 입력된 글자를 제목으로 포함하고 있는 객체들을 list에서
		// 찾음
		// 3> 화면에 검색된 객체들을 출력함
		
		System.out.print("검색할 제목 : ");
		String str = sc.nextLine();
		
		for (int i=0; i<list.size(); i++){
			if (list.get(i).getBoardTitle().indexOf(str) != -1){
				System.out.println(list.get(i));
			}
		}
		
	}

	// 8. 파일에 저장하기 메소드
	public void saveListFile() {
		// >> 구현내용
		// 1> list에 저장된 정보를 board_list.dat 파일에
		// ObjectOutputStream 클래스 사용하여 기록 저장함
		// try with resource 문 사용할 것
		// 2> "board_list.dat 에 성공적으로 저장되었습니다." 출력
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("board_list.dat"));){
			for (int i=0; i<list.size(); i++)
				oos.writeObject((Board)list.get(i));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("board_list.dat 에 성공적으로 저장되었습니다.");

	}

	// 9. 정렬처리용 메소드
	public void sortList(int item, boolean isDesc) {
		// >> 구현내용
		// 1> item 이 1이면 번호순 정렬
		// item 이 2이면 날짜순 정렬
		// item 이 3이면 제목순 정렬 작동되게 정렬용 클래스 사용함
		// 2> isDesc 가 true 이면 내림차순정렬 작동
		// isDesc 가 false 이면 오름차순정렬 작동되게 함
		
		switch (item){
		case 1: 
			if (isDesc == true)
				list.sort(new DescBoardNo());
			else
				list.sort(new AscBoardNo());
		case 2:
			if (isDesc == true)
				list.sort(new DescBoardDate());
			else
				list.sort(new AscBoardDate());
		case 3:
			if (isDesc == true)
				list.sort(new DescBoardTitle());
			else
				list.sort(new AscBoardTitle());
		}

	}
}
