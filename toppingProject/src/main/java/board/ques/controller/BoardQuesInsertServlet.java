package board.ques.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.ques.model.service.BoardQuesService;
import board.ques.model.vo.BoardQues;

/**
 * Servlet implementation class BoardQuesInsertServlet
 */
@WebServlet("/bqinsert")
public class BoardQuesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardQuesInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 질문 게시판 게시글 등록 처리용 컨트롤러
		
		// multipart 인코딩 확인
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype 속성이 누락되었습니다.");
			view.forward(request, response);
		}
		
		int maxSize = 1024 * 1024 * 100;
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/bq_upfiles");
		
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		BoardQues bques = new BoardQues();
		
		bques.setBqType(mrequest.getParameter("type"));
		bques.setBqTitle(mrequest.getParameter("title"));
		bques.setBqWriter(mrequest.getParameter("writer"));
		bques.setBqContent(mrequest.getParameter("content"));
		
		String orgFilename = mrequest.getFilesystemName("upfile");
		bques.setOrgFilename(orgFilename);
		
		if(orgFilename != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String reFilename = sdf.format(new java.sql.Date(System.currentTimeMillis()));
			
			reFilename += orgFilename.substring(orgFilename.lastIndexOf("."));
			
			File originFile = new File(savePath + "\\" + orgFilename);
			File renameFile = new File(savePath + "\\" + reFilename);
			
			// 수동으로 이름 바꾸기
			if(!originFile.renameTo(renameFile)) {
				FileInputStream fin = new FileInputStream(originFile);
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				int data = -1;
				byte[] buffer = new byte[1024];
				
				while((data = fin.read(buffer, 0, buffer.length)) != -1) {
					fout.write(buffer, 0, buffer.length);
				}
				
				fin.close();
				fout.close();
				originFile.delete();
				
			} // if
			
			bques.setReFilename(reFilename);
			
		} // if(orgFilename != null)
		
		int result = new BoardQuesService().insertBoardQues(bques);
		
		if(result > 0) {
			response.sendRedirect("bqlist?page=1");
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "새 게시글 등록 실패");
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
