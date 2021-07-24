package diary.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.model.service.DiaryService;

/**
 * Servlet implementation class DiaryDeleteServlet
 */
@WebServlet("/ddelete")
public class DiaryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여행 일기 삭제 컨트롤러
		
		int diaryNum = Integer.parseInt(request.getParameter("dnum"));
		int diaryLevel = Integer.parseInt(request.getParameter("level"));
		
			
		if(new DiaryDeleteServlet().deleteDiary(diaryNum, diaryLevel) > 0) {
			
			String renameFileName = request.getParameter("rfile");
			if(renameFileName != null) {
				String savePath = request.getSession().getServletContext().getRealPath("/resources/diary_upfiles");
				new File(savePath + "\\" + renameFileName).delete();
			}
			
			response.sendRedirect("/topp/dlist?page=1");
		}else {
			RequestDispatcher view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", diaryNum + "번 글 삭제 실패.");
			view.forward(request, response);
		}
	}

	private int deleteDiary(int diaryNum, int diaryLevel) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
