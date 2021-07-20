package User.model.service;

import User.model.dao.UserDao;
import User.model.vo.User;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static common.JDBCTemp.*;

public class UserService {
	private UserDao udao = new UserDao();
	
	public User selectLogin(String userid, String pwd) {
		Connection conn = getConnection();
		User user = udao.selectLogin(conn, userid, pwd);
		close(conn);
		return user;
	}
}
