package board.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.notice.model.service.BoardNoticeService;

/**
 * Servlet implementation class BoardNoticeDeleteServlet
 */
@WebServlet("/bndelete")
public class BoardNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 게시글 삭제 처리용 컨트롤러
		
		int bnNo = Integer.parseInt(request.getParameter("bnNo"));
		
		if(new BoardNoticeService().deleteBoardNotice(bnNo) > 0) {
			String rfile = request.getParameter("rfile");
			
			if(rfile != null) {
				String savePath = request.getSession().getServletContext().getRealPath("/resources/bn_upfiles");
				new File(savePath + "\\" + rfile).delete();
			}
			
			response.sendRedirect("/topp/bnlist?page=1");
			
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", bnNo + "번 게시글이 삭제되지 않았습니다.");
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
