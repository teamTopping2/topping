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

/**
 * Servlet implementation class BoardNoticeSearchServlet
 */
@WebServlet("/bnsearch")
public class BoardNoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 게시글 검색 처리용 컨트롤러

		// 인코딩
		request.setCharacterEncoding("utf-8");

		// 출력할 페이지 지정
		int currentPage = 1;

		// 값 추출
		String search = request.getParameter("search");
		String keyword = request.getParameter("keyword");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		int limit = 10;
		
		// 서비스로 보내고 리턴
		BoardNoticeService bnservice = new BoardNoticeService();

		int listCount = bnservice.getListCount();

		// 요청한 페이지의 출력될 목록 행 번호 계산
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		// 해당 페이지에 출력할 게시글 목록 조회
		ArrayList<BoardNotice> list = null;
		
		switch(search) {
		case "title": list = bnservice.selectSearchTitle(keyword, startRow, endRow); break;
		case "writer": list = bnservice.selectSearchWriter(keyword, startRow, endRow); break;
		case "content": list = bnservice.selectSearchContent(keyword, startRow, endRow); break;
		}

		// 뷰 페이지로 같이 내보낼 페이지 관련 숫자 계산 처리
		int maxPage = (int) ((double) listCount / limit + 0.9);

		// 뷰에 출력할 페이지 그룹의 시작 페이지 지정
		int startPage = ((int) ((double) currentPage / limit + 0.9) - 1) * limit + 1;
		int endPage = startPage + limit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}
		
		// 성공/실패 페이지
		RequestDispatcher view = request.getRequestDispatcher("views/board/boardNoticeListView.jsp");
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listCount", listCount);
		
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
