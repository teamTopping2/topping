package board.notice.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board.notice.model.vo.BoardNotice;
import board.notice.model.vo.BoardNoticeReply;

public class BoardNoticeDao {
	
	public ArrayList<BoardNotice> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<BoardNotice> list = new ArrayList<BoardNotice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from (select rownum rnum, bn_no, bn_writer, bn_title, bn_content, bn_date, org_filename, re_filename, bn_view "
				+ "         from (select * from tb_board_notice "
				+ "                    order by bn_no desc)) "
				+ "where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardNotice bnotice = new BoardNotice();
				
				bnotice.setBnNo(rset.getInt("bn_no"));
				bnotice.setBnWriter(rset.getString("bn_writer"));
				bnotice.setBnTitle(rset.getString("bn_title"));
				bnotice.setBnContent(rset.getString("bn_title"));
				bnotice.setBnDate(rset.getDate("bn_date"));
				bnotice.setOrgFilename(rset.getString("org_filename"));
				bnotice.setReFilename(rset.getString("re_filename"));
				bnotice.setBnView(rset.getInt("bn_view"));
				
				list.add(bnotice);
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
		
		String query = "select count(*) from tb_board_notice";
		
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
	
	public BoardNotice selectOne(Connection conn, int bnNo) {
		BoardNotice bnotice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_notice where bn_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bnotice = new BoardNotice();
				
				bnotice.setBnNo(bnNo);
				bnotice.setBnWriter(rset.getString("bn_writer"));
				bnotice.setBnTitle(rset.getString("bn_title"));
				bnotice.setBnContent(rset.getString("bn_content"));
				bnotice.setBnDate(rset.getDate("bn_date"));
				bnotice.setOrgFilename(rset.getString("org_filename"));
				bnotice.setReFilename(rset.getString("re_filename"));
				bnotice.setBnView(rset.getInt("bn_view"));
				bnotice.setBnLike(rset.getInt("bn_like"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bnotice;
	} // selectOne
	
	public int addReadCount(Connection conn, int bnNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_board_notice set bn_view = bn_view + 1 where bn_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // addReadCount
	
	public ArrayList<BoardNotice> selectSearchTitle(Connection conn, String keyword) {
		ArrayList<BoardNotice> list = new ArrayList<BoardNotice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_notice where bn_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardNotice bnotice = new BoardNotice();
				
				bnotice.setBnNo(rset.getInt("bn_no"));
				bnotice.setBnTitle(rset.getString("bn_title"));
				bnotice.setBnWriter(rset.getString("bn_writer"));
				bnotice.setBnContent(rset.getNString("bn_content"));
				bnotice.setBnDate(rset.getDate("bn_date"));
				bnotice.setOrgFilename(rset.getString("org_filename"));
				bnotice.setReFilename(rset.getString("re_filename"));
				bnotice.setBnView(rset.getInt("bn_view"));
				bnotice.setBnLike(rset.getInt("bn_like"));
				
				list.add(bnotice);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectSearchTitle
	
	public ArrayList<BoardNotice> selectSearchWriter(Connection conn, String bnWriter) {
		ArrayList<BoardNotice> list = new ArrayList<BoardNotice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_notice where bn_writer like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + bnWriter + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardNotice bnotice = new BoardNotice();
				
				bnotice.setBnNo(rset.getInt("bn_no"));
				bnotice.setBnTitle(rset.getString("bn_title"));
				bnotice.setBnWriter(rset.getString("bn_writer"));
				bnotice.setBnContent(rset.getNString("bn_content"));
				bnotice.setBnDate(rset.getDate("bn_date"));
				bnotice.setOrgFilename(rset.getString("org_filename"));
				bnotice.setReFilename(rset.getString("re_filename"));
				bnotice.setBnView(rset.getInt("bn_view"));
				bnotice.setBnLike(rset.getInt("bn_like"));
				
				list.add(bnotice);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectSearchWriter
	
	public ArrayList<BoardNotice> selectSearchContent(Connection conn, String bnContent) {
		ArrayList<BoardNotice> list = new ArrayList<BoardNotice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_board_notice where bn_content like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + bnContent + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardNotice bnotice = new BoardNotice();
				
				bnotice.setBnNo(rset.getInt("bn_no"));
				bnotice.setBnTitle(rset.getString("bn_title"));
				bnotice.setBnWriter(rset.getString("bn_writer"));
				bnotice.setBnContent(rset.getNString("bn_content"));
				bnotice.setBnDate(rset.getDate("bn_date"));
				bnotice.setOrgFilename(rset.getString("org_filename"));
				bnotice.setReFilename(rset.getString("re_filename"));
				bnotice.setBnView(rset.getInt("bn_view"));
				bnotice.setBnLike(rset.getInt("bn_like"));
				
				list.add(bnotice);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectSearchContent
	
	public int insertBoardNotice(Connection conn, BoardNotice bnotice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_board_notice values (bn_seq.nextval, ?, ?, ?, default, ?, ?, default, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bnotice.getBnWriter());
			pstmt.setString(2, bnotice.getBnTitle());
			pstmt.setString(3, bnotice.getBnContent());
			pstmt.setString(4, bnotice.getOrgFilename());
			pstmt.setString(5, bnotice.getReFilename());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // insertBoardNotice
	
	public int updateBoardNotice(Connection conn, BoardNotice bnotice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_board_notice set bn_writer = ?, bn_title = ?, bn_content = ?, org_filename = ?, re_filename = ? where bn_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bnotice.getBnWriter());
			pstmt.setString(2, bnotice.getBnTitle());
			pstmt.setString(3, bnotice.getBnContent());
			pstmt.setString(4, bnotice.getOrgFilename());
			pstmt.setString(5, bnotice.getReFilename());
			pstmt.setInt(6, bnotice.getBnNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // updateBoardNotice
	
	public int deleteBoardNotice(Connection conn, int bnNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_board_notice where bn_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // deleteBoardNotice
	
	public ArrayList<BoardNoticeReply> selectReplyList(Connection conn, int bnNo) {
		ArrayList<BoardNoticeReply> list = new ArrayList<BoardNoticeReply>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_comment_bn where bn_no = ? order by com_no";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BoardNoticeReply bnreply = new BoardNoticeReply();
				
				bnreply.setBnNo(rset.getInt("bn_no"));
				bnreply.setComNo(rset.getInt("com_no"));
				bnreply.setComWriter(rset.getString("com_writer"));
				bnreply.setComContent(rset.getString("com_content"));
				bnreply.setComDate(rset.getDate("com_date"));
				
				list.add(bnreply);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	} // selectReplyList
	
	public int insertReply(Connection conn, BoardNoticeReply bnreply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_comment_bn values (?, cbn_seq.nextval, ?, ?, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnreply.getBnNo());
			pstmt.setString(2, bnreply.getComWriter());
			pstmt.setString(3, bnreply.getComContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} // insertReply
	
	public int updateReply(Connection conn, BoardNoticeReply bnreply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_comment_bn set com_content = ? where bn_no = ? and com_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bnreply.getComContent());
			pstmt.setInt(2, bnreply.getBnNo());
			pstmt.setInt(3, bnreply.getComNo());
			
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
		
		String query = "delete from tb_comment_bn where com_no = ?";
		
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
