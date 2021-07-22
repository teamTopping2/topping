package board.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.notice.model.service.BoardNoticeService;
import board.notice.model.vo.BoardNotice;

/**
 * Servlet implementation class BoardNoticeUpdateViewServlet
 */
@WebServlet("/bnupview")
public class BoardNoticeUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 게시글 수정 페이지 출력 처리용 컨트롤러
		
		int bnNo = Integer.parseInt(request.getParameter("bnNo"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		// 해당 글 조회
		BoardNotice bnotice = new BoardNoticeService().selectOne(bnNo);
		
		RequestDispatcher view = null;
		if(bnotice != null) {
			view = request.getRequestDispatcher("views/board/boardNoticeUpdateView.jsp");
			request.setAttribute("bnotice", bnotice);
			request.setAttribute("page", currentPage);
			
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", bnNo + "번 게시글 수정 페이지를 불러오는 데 실패했습니다.");
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
