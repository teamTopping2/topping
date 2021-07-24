package diary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.model.service.DiaryService;
import diary.model.vo.Diary;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/ddetail")
public class DiaryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여행 일기 상세보기 컨트롤러
		
		int diaryNum = Integer.parseInt(request.getParameter("dnum"));
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		

		DiaryService dservice = new DiaryService();
		

		dservice.addReadCount(diaryNum);
		

		Diary diary = dservice.selectDiary(diaryNum);
		
		RequestDispatcher view = null;
		if(diary != null) {
			view = request.getRequestDispatcher("views/diary/diaryDetailView.jsp");
			
			request.setAttribute("diary", diary);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", diaryNum + "번 게시글 상세조회 실패!");
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
