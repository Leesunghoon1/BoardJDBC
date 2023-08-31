package boardJDBC;

import java.util.List;

import board.Board;

public class BoardServiceImpl implements Service {
	private DAO dao;
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO b) {
		System.out.println("register_service success!!");
		// dao에서 사용되는 메서드명 DB 구문과 비슷하게 하는것이 일반적
		return dao.insert(b);
	}

	@Override
	public List<BoardVO> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}

	@Override
	public BoardVO detail(int bno) {
		int isOK = dao.readCount(bno);
		System.out.println("list_service success!!");
		return (isOK>0)? dao.selectOne(bno) : null;
	}

	@Override
	public int modify(BoardVO b) {
		System.out.println("list_service success!!");
		return dao.selectModify(b);
	}

	@Override
	public int remove(int bno) {
		System.out.println("list_service success!!");
		return dao.selectRemove(bno);
	}
}
