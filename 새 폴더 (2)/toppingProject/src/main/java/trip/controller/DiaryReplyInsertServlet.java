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
import trip.model.service.DiaryService;
import trip.model.vo.Diary;

/**
 * Servlet implementation class BoardReplyInsertServlet
 */
@WebServlet("/dreply")
public class DiaryReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 댓글 등록 처리용 컨트롤러
		//1.
		request.setCharacterEncoding("utf-8");
		
		//2.
		//댓글에 대한 원글 번호 추출
		int diaryNum = Integer.parseInt(request.getParameter("dnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		//댓글에 대한 값 추출해서 객체에 저장
		Diary reply = new Diary();
		
		reply.setDiaryTitle(request.getParameter("title"));
		reply.setDiaryWriter(request.getParameter("writer"));
		reply.setDiaryContent(request.getParameter("content"));
		
		//원글 조회
		DiaryService bservice = new DiaryService();
		Diary origin = bservice.selectDiary(diaryNum);
		
		//댓글에 diary_level(댓글레벨), diary_ref (참조 원글번호)
		reply.setDiaryLevel(origin.getDiaryLevel() + 1);
		reply.setDiaryRef(origin.getDiaryRef());
		
		//diary_reply_ref (참조하는 댓글번호)
		//원글일 때 null, 원글의 댓글이면(level : 2) 자기번호,
		//댓글의 댓글이면(level : 3) 참조하는 댓글번호
		if(reply.getDiaryLevel() == 3) {  //대댓글이면
			reply.setDiaryReplyRef(origin.getDiaryReplyRef());
		}
		
		//댓글의 순번 처리
		//최신 댓글이 무조건 1이 되게 함
		reply.setDiaryReplySeq(1);
		//이전 댓글의 순번을 모두 1증가 처리함
//		bservice.updateReplySeq(reply);  //update 로 1증가 처리
		
		//3.
		int result = bservice.insertReplyDiary(reply);
		
		if(result > 0) {
			response.sendRedirect("/trip/dlist?page=" + currentPage);
		}else {
			RequestDispatcher view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", 
					diaryNum + "번 게시글 댓글 등록 실패!");
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
