package User.model.dao;

import java.sql.*;
import static common.JDBCTemp.close;
import User.model.vo.User;

public class UserDao {
	public User selectLogin(Connection conn, String userid, String pwd) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from user where userid = ? and pwd = ?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				user.setUserno(rset.getInt("userno"));
				user.setNickname(rset.getString("nickname"));
				user.setUserid(userid);
				user.setPwd(pwd);
				user.setUsername(rset.getString("username"));
				user.setUserimg(rset.getString("userimg"));
				user.setPhone(rset.getString("phone"));
				user.setUserstatus(rset.getString("userstatus"));
				user.setAuthority(rset.getString("authority"));
				user.setEnrolldate(rset.getDate("enrolldate"));
				user.setDeletedate(rset.getDate("deletedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return user;
	}
}
