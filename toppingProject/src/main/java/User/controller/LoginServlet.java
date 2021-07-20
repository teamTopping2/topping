package User.controller;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.model.service.UserService;
import User.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		System.out.println(userid + ", " + pwd);

		
		User user = new UserService().selectLogin(userid, pwd);
		
		if(user != null) {//로그인 성공
			
		}else {//로그인 실패
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			if (user != null && user.getUserstatus().equals("1")) {
				request.setAttribute("message", "???.");
			}
			
			if( user == null ) {
				request.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			}
			
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
