package boardJDBC;

import java.util.List;

import board.Board;

public interface DAO {

	int insert(BoardVO b);

	List<BoardVO> selectList();

	BoardVO selectOne(int bno);

	int selectModify(BoardVO b);

	int selectRemove(int bno);

	int readCount(int bno);
	
	
	
	
}
