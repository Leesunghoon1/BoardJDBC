package boardJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.Product;
import board.Board;



public class BoardDAOImpl implements DAO{
	
	//DB 연결
	private Connection conn;
	//Sql 구문을 실행시키는 기능을 갖는 객체
	private PreparedStatement pst; //임포트
	private String query = ""; //쿼리 구문 저장
	
	public BoardDAOImpl() {
		//데이터베이스 객체 생성
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public int insert(BoardVO b) {
		System.out.println("insert Board success!!");
		query = "insert into board(title, writer, content) values(?,?,?)";
		// TODO Auto-generated method stub
		try {
			//query구문을 받고 pst에 전달
			pst = conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			//insert, update, delete => executeUpdate() in타입으로 return 
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<BoardVO> selectList() {
		
		System.out.println("insert DAO success!!");
		query = "select * from board Order by bno desc ";
		List<BoardVO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("regdate"),
						rs.getInt("readcount"))); 
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("selectList error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BoardVO selectOne(int bno) {
		System.out.println("detail_DAO success!!");
		query = "select * from board where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new BoardVO(rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getString("moddate"),
						rs.getInt("readcount"));
			}
		} catch (Exception e) {
			System.out.println("selectcOne erro");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectModify(BoardVO b) {
		System.out.println("update DAO success!!");
		query =  "update board SET title = ?, writer = ?, content = ? WHERE bno = ?";
		try {
			//query구문을 받고 pst에 전달
			pst = conn.prepareStatement(query);
			
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			pst.setInt(4, b.getBno());
			//insert, update, delete => executeUpdate() in타입으로 return 
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int selectRemove(int bno) {
		System.out.println("delete DAO success!!");
		query =  "delete from board where bno = ?";
		try {
			//query구문을 받고 pst에 전달
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			//insert, update, delete => executeUpdate() in타입으로 return 
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int readCount(int bno) {
		System.out.println("update DAO success!!");
		query =  "update board SET readCount= readCount +1 where bno = ?";
		try {
			//query구문을 받고 pst에 전달
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, bno);
			//insert, update, delete => executeUpdate() in타입으로 return 
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}
}
