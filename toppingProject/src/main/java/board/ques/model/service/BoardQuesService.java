package board.ques.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.ques.model.dao.BoardQuesDao;
import board.ques.model.vo.BoardQues;
import board.ques.model.vo.BoardQuesReply;
import static common.JDBCTemp.*;

public class BoardQuesService {
	BoardQuesDao bqdao = new BoardQuesDao();
	
	public ArrayList<BoardQues> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BoardQues> list = bqdao.selectList(conn, startRow, endRow);
		close(conn);
		
		return list;
	}
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bqdao.getListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	public BoardQues selectOne(int bqNo) {
		Connection conn = getConnection();
		BoardQues bques = bqdao.selectOne(conn, bqNo);
		close(conn);
		
		return bques;
	}
	
	public void addReadCount(int bqNo) {
		Connection conn = getConnection();
		int readCount = bqdao.addReadCount(conn, bqNo);
		
		if(readCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
	}
	
	public void addLikeCount(int bqNo) {
		Connection conn = getConnection();
		int likeCount = bqdao.addLikeCount(conn, bqNo);
		
		if(likeCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
	}
	
	public void addRepCount(int bqNo) {
		Connection conn = getConnection();
		int likeCount = bqdao.addRepCount(conn, bqNo);
		
		if(likeCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
	}
	
	public ArrayList<BoardQues> selectSearchTitle(String bqTitle) {
		Connection conn = getConnection();
		ArrayList<BoardQues> list = bqdao.selectSearchTitle(conn, bqTitle);
		close(conn);
		
		return list;
	}
	
	public ArrayList<BoardQues> selectSearchWriter(String bqWriter) {
		Connection conn = getConnection();
		ArrayList<BoardQues> list = bqdao.selectSearchWriter(conn, bqWriter);
		close(conn);
		
		return list;
	}
	
	public ArrayList<BoardQues> selectSearchContent(String bqContent) {
		Connection conn = getConnection();
		ArrayList<BoardQues> list = bqdao.selectSearchContent(conn, bqContent);
		close(conn);
		
		return list;
	}
	
	public int insertBoardQues(BoardQues bques) {
		Connection conn = getConnection();
		int result = bqdao.insertBoardQues(conn, bques);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int updateBoardQues(BoardQues bques) {
		Connection conn = getConnection();
		int result = bqdao.updateBoardQues(conn, bques);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int deleteBoardQues(int bqNo) {
		Connection conn = getConnection();
		int result = bqdao.deleteBoardQues(conn, bqNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public ArrayList<BoardQuesReply> selectReplyList(int bqNo) {
		Connection conn = getConnection();
		ArrayList<BoardQuesReply> list = bqdao.selectReplyList(conn, bqNo);
		close(conn);
		
		return list;
	}
	
	public int insertReply (BoardQuesReply bqreply) {
		Connection conn = getConnection();
		int result = bqdao.insertReply(conn, bqreply);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int updateReply (BoardQuesReply bqreply) {
		Connection conn = getConnection();
		int result = bqdao.updateReply(conn, bqreply);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int deleteReply (int comNo) {
		Connection conn = getConnection();
		int result = bqdao.deleteReply(conn, comNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	
}
