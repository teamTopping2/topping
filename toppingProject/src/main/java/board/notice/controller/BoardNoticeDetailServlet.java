package board.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.notice.model.service.BoardNoticeService;
import board.notice.model.vo.BoardNotice;
import board.notice.model.vo.BoardNoticeReply;

/**
 * Servlet implementation class BoardNoticeDetailServlet
 */
@WebServlet("/bndetail")
public class BoardNoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 상세보기 페이지
		
		int bnNo = Integer.parseInt(request.getParameter("bnNo"));
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardNoticeService bnservice = new BoardNoticeService();
//		BoardNoticeReply bnreply = new BoardNoticeReply();
		
		bnservice.addReadCount(bnNo);
		
		BoardNotice bnotice = bnservice.selectOne(bnNo);
		ArrayList<BoardNoticeReply> list = bnservice.selectReplyList(bnNo);
		
		// 성공 실패 처리
		RequestDispatcher view = null;
		if(bnotice != null) {
			view = request.getRequestDispatcher("views/board/boardNoticeDetailView.jsp");
			request.setAttribute("bnotice", bnotice);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("list", list);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", bnNo + "번 게시글 상세조회 실패");
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
