package board.ques.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board.ques.model.vo.BoardQues;
import board.ques.model.vo.BoardQuesReply;

public class BoardQuesDao {
	
	public ArrayList<BoardQues> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<BoardQues> list = new ArrayList<BoardQues>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, bq_no, bq_type, bq_writer, bq_title, bq_content, bq_date, org_filename, re_filename, bq_view "
				+ "         from (select * from tb_board_ques "
				+ "                    order by bq_no desc)) "
				+ "where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardQues bques = new BoardQues();
				
				bques.setBqNo(rset.getInt("bq_no"));
				bques.setBqType(rset.getString("bq_type"));
				bques.setBqWriter(rset.getString("bq_writer"));
				bques.setBqTitle(rset.getString("bq_title"));
				bques.setBqContent(rset.getString("bq_title"));
				bques.setBqDate(rset.getDate("bq_date"));
				bques.setOrgFilename(rset.getString("org_filename"));
				bques.setReFilename(rset.getString("re_filename"));
				bques.setBqView(rset.getInt("bq_view"));
				
				list.add(bques);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectList
	
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_board_ques";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	} // getListCount
	
	public BoardQues selectOne(Connection conn, int bqNo) {
		BoardQues bques = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_ques where bq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bqNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bques = new BoardQues();
				
				bques.setBqNo(bqNo);
				bques.setBqType(rset.getString("bq_type"));
				bques.setBqWriter(rset.getString("bq_writer"));
				bques.setBqTitle(rset.getString("bq_title"));
				bques.setBqContent(rset.getString("bq_content"));
				bques.setBqDate(rset.getDate("bq_date"));
				bques.setOrgFilename(rset.getString("org_filename"));
				bques.setReFilename(rset.getString("re_filename"));
				bques.setBqView(rset.getInt("bq_view"));
				bques.setBqLike(rset.getInt("bq_like"));
				bques.setRepCount(rset.getInt("rep_count"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bques;
	} // selectOne
	
	public int addReadCount(Connection conn, int bqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_board_ques set bq_view = bq_view + 1 where bq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bqNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // addReadCount
	
	public int addLikeCount(Connection conn, int bqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_board_ques set bq_like = bq_like + 1 where bq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bqNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // addLikeCount
	
	public int addRepCount(Connection conn, int bqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_board_ques set rep_count = rep_count + 1 where bq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bqNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // addRepCount
	
	public ArrayList<BoardQues> selectSearchType(Connection conn, String bqType) {
		ArrayList<BoardQues> list = new ArrayList<BoardQues>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_ques where bq_type = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bqType);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardQues bques = new BoardQues();
				
				bques.setBqNo(rset.getInt("bq_no"));
				bques.setBqType(rset.getString("bq_type"));
				bques.setBqTitle(rset.getString("bq_title"));
				bques.setBqWriter(rset.getString("bq_writer"));
				bques.setBqContent(rset.getNString("bq_content"));
				bques.setBqDate(rset.getDate("bq_date"));
				bques.setOrgFilename(rset.getString("org_filename"));
				bques.setReFilename(rset.getString("re_filename"));
				bques.setBqView(rset.getInt("bq_view"));
				bques.setBqLike(rset.getInt("bq_like"));
				bques.setRepCount(rset.getInt("rep_count"));
				
				list.add(bques);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectSearchType
	
	public ArrayList<BoardQues> selectSearchTitle(Connection conn, String keyword) {
		ArrayList<BoardQues> list = new ArrayList<BoardQues>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_ques where bq_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardQues bques = new BoardQues();
				
				bques.setBqNo(rset.getInt("bq_no"));
				bques.setBqType(rset.getString("bq_type"));
				bques.setBqTitle(rset.getString("bq_title"));
				bques.setBqWriter(rset.getString("bq_writer"));
				bques.setBqContent(rset.getNString("bq_content"));
				bques.setBqDate(rset.getDate("bq_date"));
				bques.setOrgFilename(rset.getString("org_filename"));
				bques.setReFilename(rset.getString("re_filename"));
				bques.setBqView(rset.getInt("bq_view"));
				bques.setBqLike(rset.getInt("bq_like"));
				bques.setRepCount(rset.getInt("rep_count"));
				
				list.add(bques);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectSearchTitle
	
	public ArrayList<BoardQues> selectSearchWriter(Connection conn, String bqWriter) {
		ArrayList<BoardQues> list = new ArrayList<BoardQues>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_ques where bq_writer like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + bqWriter + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardQues bques = new BoardQues();
				
				bques.setBqNo(rset.getInt("bq_no"));
				bques.setBqType(rset.getString("bq_type"));
				bques.setBqTitle(rset.getString("bq_title"));
				bques.setBqWriter(rset.getString("bq_writer"));
				bques.setBqContent(rset.getNString("bq_content"));
				bques.setBqDate(rset.getDate("bq_date"));
				bques.setOrgFilename(rset.getString("org_filename"));
				bques.setReFilename(rset.getString("re_filename"));
				bques.setBqView(rset.getInt("bq_view"));
				bques.setBqLike(rset.getInt("bq_like"));
				bques.setRepCount(rset.getInt("rep_count"));
				
				list.add(bques);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectSearchWriter
	
	public ArrayList<BoardQues> selectSearchContent(Connection conn, String bqContent) {
		ArrayList<BoardQues> list = new ArrayList<BoardQues>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_ques where bq_content like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + bqContent + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardQues bques = new BoardQues();
				
				bques.setBqNo(rset.getInt("bq_no"));
				bques.setBqType(rset.getString("bq_type"));
				bques.setBqTitle(rset.getString("bq_title"));
				bques.setBqWriter(rset.getString("bq_writer"));
				bques.setBqContent(rset.getNString("bq_content"));
				bques.setBqDate(rset.getDate("bq_date"));
				bques.setOrgFilename(rset.getString("org_filename"));
				bques.setReFilename(rset.getString("re_filename"));
				bques.setBqView(rset.getInt("bq_view"));
				bques.setBqLike(rset.getInt("bq_like"));
				bques.setRepCount(rset.getInt("rep_count"));
				
				list.add(bques);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectSearchContent
	
	public int insertBoardQues(Connection conn, BoardQues bques) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_board_ques values ((select max(bq_no) + 1 from tb_board_ques), ?, ?, ?, ?, default, ?, ?, default, default, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bques.getBqType());
			pstmt.setString(2, bques.getBqWriter());
			pstmt.setString(3, bques.getBqTitle());
			pstmt.setString(4, bques.getBqContent());
			pstmt.setString(5, bques.getOrgFilename());
			pstmt.setString(6, bques.getReFilename());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // insertBoardQues
	
	public int updateBoardQues(Connection conn, BoardQues bques) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_board_ques set bq_type = ?, bq_writer = ?, bq_title = ?, bq_content = ?, org_filename = ?, re_filename = ? where bq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bques.getBqType());
			pstmt.setString(2, bques.getBqWriter());
			pstmt.setString(3, bques.getBqTitle());
			pstmt.setString(4, bques.getBqContent());
			pstmt.setString(5, bques.getOrgFilename());
			pstmt.setString(6, bques.getReFilename());
			pstmt.setInt(7, bques.getBqNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // updateBoardQues
	
	public int deleteBoardQues(Connection conn, int bqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_board_ques where bq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bqNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // deleteBoardQues
	
	public ArrayList<BoardQuesReply> selectReplyList(Connection conn, int bqNo) {
		ArrayList<BoardQuesReply> list = new ArrayList<BoardQuesReply>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_comment_bq where bq_no = ? order by com_no";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bqNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardQuesReply bqreply = new BoardQuesReply();
				
				bqreply.setBqNo(rset.getInt("bq_no"));
				bqreply.setComNo(rset.getInt("com_no"));
				bqreply.setComWriter(rset.getString("com_writer"));
				bqreply.setComContent(rset.getString("com_content"));
				bqreply.setComDate(rset.getDate("com_date"));
				
				list.add(bqreply);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectReplyList
	
	public int insertReply(Connection conn, BoardQuesReply bqreply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_comment_bq values (?, cbq_seq.nextval, ?, ?, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bqreply.getBqNo());
			pstmt.setString(2, bqreply.getComWriter());
			pstmt.setString(3, bqreply.getComContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // insertReply
	
	public int updateReply(Connection conn, BoardQuesReply bqreply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_comment_bq set com_content = ? where bq_no = ? and com_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bqreply.getComContent());
			pstmt.setInt(2, bqreply.getBqNo());
			pstmt.setInt(3, bqreply.getComNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // updateReply
	
	public int deleteReply(Connection conn, int comNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_comment_bq where com_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, comNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // deleteReply
	
}
