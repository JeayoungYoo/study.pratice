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
			System.out.println("����Ʈ ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		// >> �������� : board_list.dat ������ ������ �о
		// list�� ������
		// null �� ������ ������

	// 1. �Խñ� ���� �޼ҵ�
	public void writeBoard() {
		String title, writer;
		StringBuilder contents = new StringBuilder();
		Date date = new Date();
		
		// >> ��������
		// 1> "�� �Խñ� ���� �Դϴ�." ���
		// 2> "������ : " >> �Է¹���(��������)
		// 3> "�ۼ��� : " >> �̸� �Է¹��� (�������)
		// 4> �ۼ���¥�� ���� ��¥�� �Է�ó����
		// 5> "�۳��� : " >> ���� �ٷ� �Է¹���
		// "exit" �Է��ϸ� �Է�����
		// 6> Board ��ü ������ �ʱⰪ���� �����
		// 7> list�� �߰���
		System.out.println("�� �Խñ� ���� �Դϴ�.");
		System.out.println("-----------------------------");
		System.out.print("������ : ");
		title = sc.nextLine()+sc.nextLine();
		System.out.print("�ۼ��� : ");
		writer = sc.next();
		System.out.print("�۳��� : ");
		while(true){
			String str = sc.nextLine();
			if (str.equals("exit")){
				System.out.println("�۾��⸦ �����մϴ�");
				break;
			}
			contents.append(str + "\n");
		}
		list.add(new Board(num, title, writer, date, contents.toString(), 0));
		num++;

	}

	// 2. �Խñ� ��ü ���� �޼ҵ�
	public void displayAllList() {
		// >> ��������
		// 1> list �� ��ϵ� ������ ��� ȭ�鿡 ��½�Ŵ
		for (int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}

	// 3. �Խñ� �Ѱ� ���� �޼ҵ�
	public void displayBoard() {
		// >> ��������
		// 1> "��ȸ�� �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> �ش� �ۿ� ���� ��ȸ�� 1���� ó����
		System.out.print("��ȸ�� �۹�ȣ : ");
		index = sc.nextInt();
		list.get(index).setReadCount(list.get(index).getReadCount()+1);
		System.out.println(list.get(index));
		

	}

	// 4. �Խñ� ���� ���� �޼ҵ�
	public void modifyTitle() {
		// >> ��������
		// 1> "������ �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> "������ ���� : " >> �� ���� �Է¹��� >> ���񺯰�
		// 4> ����� ��ü ������ list�� �ش� ��ȣ ��ü�� ������
		System.out.print("������ �۹�ȣ : ");
		index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("������ ���� : ");
		list.get(index).setBoardTitle(sc.nextLine()+sc.nextLine());
		// 4> Ȯ�� �ʿ�

	}

	// 5. �Խñ� ���� ���� �޼ҵ�
	public void modifyContent() {
		// >> ��������
		// 1> "������ �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> "������ ���� : " >> �� ���� �Է¹��� >> ���뺯��
		// 4> ����� ��ü ������ list�� �ش� ��ȣ ��ü�� ������
		StringBuilder sb = new StringBuilder();
		
		System.out.print("������ �۹�ȣ : ");
		index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("������ ���� : ");
		while(true){
			String str = sc.nextLine();
			if (str.equals("exit")){
				System.out.println("�۾��⸦ �����մϴ�");
				break;
			}
			sb.append(str + "\n");
		}
		list.get(index).setBoardContent(sb.toString());
		// �̰͵� 4�� Ȯ�� �ʿ�

	}

	// 6. �Խñ� ���� �޼ҵ�
	public void deleteBoard() {
		// >> ��������
		// 1> "������ �۹�ȣ : " >> �Է¹���
		// 2> �ش� �۹�ȣ�� ���� �Խñ��� ȭ�鿡 ��½�Ŵ
		// 3> "������ �����Ͻðڽ��ϱ�? (y/n) : "
		System.out.print("������ �۹�ȣ : ");
		index = sc.nextInt();
		System.out.println(list.get(index));
		System.out.print("������ �����Ͻðڽ��ϱ�? (y/n) : ");
		if (sc.next().toUpperCase().charAt(0) == 'y'){
			list.remove(index);
			System.out.println("���� �Ϸ�");
		}
	}

	// 7. �Խñ� �˻� �޼ҵ�
	public void searchBoard() {
		// >> ��������
		// 1> "�˻��� ���� : " >> �˻��� ���ڸ� �Է¹���
		// 2> �Էµ� ���ڸ� �������� �����ϰ� �ִ� ��ü���� list����
		// ã��
		// 3> ȭ�鿡 �˻��� ��ü���� �����
		
		System.out.print("�˻��� ���� : ");
		String str = sc.nextLine();
		
		for (int i=0; i<list.size(); i++){
			if (list.get(i).getBoardTitle().indexOf(str) != -1){
				System.out.println(list.get(i));
			}
		}
		
	}

	// 8. ���Ͽ� �����ϱ� �޼ҵ�
	public void saveListFile() {
		// >> ��������
		// 1> list�� ����� ������ board_list.dat ���Ͽ�
		// ObjectOutputStream Ŭ���� ����Ͽ� ��� ������
		// try with resource �� ����� ��
		// 2> "board_list.dat �� ���������� ����Ǿ����ϴ�." ���
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("board_list.dat"));){
			for (int i=0; i<list.size(); i++)
				oos.writeObject((Board)list.get(i));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("board_list.dat �� ���������� ����Ǿ����ϴ�.");

	}

	// 9. ����ó���� �޼ҵ�
	public void sortList(int item, boolean isDesc) {
		// >> ��������
		// 1> item �� 1�̸� ��ȣ�� ����
		// item �� 2�̸� ��¥�� ����
		// item �� 3�̸� ����� ���� �۵��ǰ� ���Ŀ� Ŭ���� �����
		// 2> isDesc �� true �̸� ������������ �۵�
		// isDesc �� false �̸� ������������ �۵��ǰ� ��
		
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
