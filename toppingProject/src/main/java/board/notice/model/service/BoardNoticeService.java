package board.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.notice.model.dao.BoardNoticeDao;
import board.notice.model.vo.BoardNotice;
import board.notice.model.vo.BoardNoticeReply;
import static common.JDBCTemp.*;

public class BoardNoticeService {
	BoardNoticeDao bndao = new BoardNoticeDao();
	
	public ArrayList<BoardNotice> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BoardNotice> list = bndao.selectList(conn, startRow, endRow);
		close(conn);
		
		return list;
	}
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bndao.getListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	public BoardNotice selectOne(int bnNo) {
		Connection conn = getConnection();
		BoardNotice bnotice = bndao.selectOne(conn, bnNo);
		close(conn);
		
		return bnotice;
	}
	
	public void addReadCount(int bnNo) {
		Connection conn = getConnection();
		int readCount = bndao.addReadCount(conn, bnNo);
		
		if(readCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
	}
	
	public ArrayList<BoardNotice> selectSearchTitle(String bnTitle, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BoardNotice> list = bndao.selectSearchTitle(conn, bnTitle, startRow, endRow);
		close(conn);
		
		return list;
	}
	
	public ArrayList<BoardNotice> selectSearchWriter(String bnWriter, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BoardNotice> list = bndao.selectSearchWriter(conn, bnWriter, startRow, endRow);
		close(conn);
		
		return list;
	}
	
	public ArrayList<BoardNotice> selectSearchContent(String bnContent, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BoardNotice> list = bndao.selectSearchContent(conn, bnContent, startRow, endRow);
		close(conn);
		
		return list;
	}
	
	public int insertBoardNotice(BoardNotice bnotice) {
		Connection conn = getConnection();
		int result = bndao.insertBoardNotice(conn, bnotice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int updatBoardNotice(BoardNotice bnotice) {
		Connection conn = getConnection();
		int result = bndao.updateBoardNotice(conn, bnotice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int deleteBoardNotice(int bnNo) {
		Connection conn = getConnection();
		int result = bndao.deleteBoardNotice(conn, bnNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public ArrayList<BoardNoticeReply> selectReplyList(int bnNo) {
		Connection conn = getConnection();
		ArrayList<BoardNoticeReply> list = bndao.selectReplyList(conn, bnNo);
		close(conn);
		
		return list;
	}
	
	public int insertReply (BoardNoticeReply bnreply) {
		Connection conn = getConnection();
		int result = bndao.insertReply(conn, bnreply);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int updateReply (BoardNoticeReply bnreply) {
		Connection conn = getConnection();
		int result = bndao.updateReply(conn, bnreply);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int deleteReply (int comNo) {
		Connection conn = getConnection();
		int result = bndao.deleteReply(conn, comNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	
}
