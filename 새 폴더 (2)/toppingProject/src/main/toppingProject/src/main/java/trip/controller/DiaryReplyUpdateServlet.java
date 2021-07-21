package trip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trip.model.service.DiaryService;
import trip.model.vo.Diary;

/**
 * Servlet implementation class BoardReplyUpdateServlet
 */
@WebServlet("/dreplyupdate")
public class DiaryReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryReplyUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 댓글/대댓글 수정 처리용 컨트롤러
		
		request.setCharacterEncoding("utf-8");
		
		Diary reply = new Diary();
		reply.setDiaryNum(Integer.parseInt(
				request.getParameter("dnum")));
		reply.setDiaryTitle(request.getParameter("title"));
		reply.setDiaryContent(request.getParameter("content"));
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		int result = new DiaryService().updateReply(reply);
				
		if (result > 0) {
		
			response.sendRedirect("ddetail?bnum=" 
						+ reply.getDiaryNum()+ "&page="
						+ currentPage);
			
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", 
					reply.getDiaryNum() + "번 게시 원글 수정 실패!");
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
