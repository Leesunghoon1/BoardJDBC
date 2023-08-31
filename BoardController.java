package boardJDBC;

import java.util.List;
import java.util.Scanner;

import JDBC.Product;
import board.Board;

public class BoardController {
	
	private Scanner scan;
	private Service svc; //인터페이스로 만들꺼니 추후 수정
	private boolean flag;
	
	public BoardController() {
		scan = new Scanner(System.in); //기본으로 다 들어감
		svc = new BoardServiceImpl();
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--게시판--");
			System.out.println("1.글쓰기|2.글목록보기|3.글상세보기");
			System.out.println("4.글수정|5.글삭제|6.종료");
			System.out.println("메뉴선택>>");
			
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: content();
				break;
			case 2: list();
				break;
			case 3: read();
				break;
			case 4: modify();
				break;
			case 5: remove();
				break;
			default:
				flag = false;
				break;
			}
			
		}
	}

	private void remove() {
		System.out.println("수정할 번호를 입력해주세요 >>");
		int bno = scan.nextInt();
		int isOk = svc.remove(bno);
		System.out.println("상품수정" + ((isOk > 0) ? "성공" : "실패"));
		
	}

	private void modify() {
		// 상품수정 pno에 해당하는 객체를 수정(pname, price, madeby)
				System.out.println("수정할 번호를 입력해주세요 >>");
				int bno = scan.nextInt();
				System.out.println("제목변경 >>");
				String title = scan.next();
				System.out.println("작가변경 >>");
				String writer = scan.next();
				System.out.println("상세내역변경 >>");
				scan.nextLine(); //위쪽 공백처리
				String content = scan.nextLine();
				BoardVO b = new BoardVO(bno, title, writer, content); // 생성자 호출
				//서비스에게 등록을 요청 메서드 작성 svc
				int isOk = svc.modify(b);
				//isOk : DB에서 insert되고난 후 리턴해주는 값
				//잘되면 1을 리턴, 안되면 0을 리턴
				System.out.println("상품수정" + ((isOk > 0) ? "성공" : "실패"));
			}
	
	
	private void read() {
		System.out.println("글 번호 >>");
		int bno = scan.nextInt(); // 숫자받기
		BoardVO p = svc.detail(bno);
			p.printDetail();
		
	}
	private void list() {
		// TODO Auto-generated method stub
		List<BoardVO> list = svc.list();
		//출력
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}

	private void content() {
		
		System.out.println("제목 >>");
		String title = scan.next();
		System.out.println("글쓴이 >>");
		String writer = scan.next();
		System.out.println("상세내용 >>");
		String content = scan.next();
		BoardVO b = new BoardVO(title, writer, content);
		int isOk = svc.register(b);
		System.out.println("등록" + ((isOk > 0) ? "성공" : "실패"));
		
	}
}

