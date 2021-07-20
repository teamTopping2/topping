package board.ques.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.ques.model.service.BoardQuesService;
import board.ques.model.vo.BoardQues;
import board.ques.model.vo.BoardQuesReply;

/**
 * Servlet implementation class BoardQuesDetailServlet
 */
@WebServlet("/bqdetail")
public class BoardQuesDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardQuesDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 상세보기 페이지

		int bqNo = Integer.parseInt(request.getParameter("bqNo"));

		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		BoardQuesService bqservice = new BoardQuesService();

		bqservice.addReadCount(bqNo);

		BoardQues bques = bqservice.selectOne(bqNo);
		ArrayList<BoardQuesReply> list = bqservice.selectReplyList(bqNo);

		// 성공 실패 처리
		RequestDispatcher view = null;
		if (bques != null) {
			view = request.getRequestDispatcher("views/board/boardQuesDetailView.jsp");
			request.setAttribute("bques", bques);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("list", list);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", bqNo + "번 게시글 상세조회 실패");
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
