package board.notice.controller;

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

import board.notice.model.service.BoardNoticeService;
import board.notice.model.vo.BoardNotice;

/**
 * Servlet implementation class BoardNoticeInsertServlet
 */
@WebServlet("/bninsert")
public class BoardNoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 게시글 등록 처리용 컨트롤러
		
		// 인코딩 됐는지 확인 -> 안 됐으면 에러 페이지 출력
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype 속성이 누락됐습니다");
			view.forward(request, response);
		}
		
		// 업로드할 파일의 용량 제한: 100MB
		int maxSize = 1024 * 1024 * 100;
		
		// 저장 폴더 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/bn_upfiles");
		
		// MultipartRequest 변환
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// 값 추출
		BoardNotice bnotice = new BoardNotice();
		
		bnotice.setBnTitle(mrequest.getParameter("title"));
		bnotice.setBnWriter(mrequest.getParameter("writer"));
		bnotice.setBnContent(mrequest.getParameter("content"));
		
		String originalFilename = mrequest.getFilesystemName("upfile");
		bnotice.setOrgFilename(originalFilename);
		
		if(originalFilename != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String reFilename = sdf.format(new java.sql.Date(System.currentTimeMillis()));
			
			reFilename += originalFilename.substring(originalFilename.lastIndexOf("."));
			
			File originFile = new File(savePath + "\\" + originalFilename);
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
			
			bnotice.setReFilename(reFilename);
			System.out.println(bnotice.getReFilename());
			
		} // if(orgFilename != null)
		
		// 서비스 메소드로 전달하고 결과 받기
		int result = new BoardNoticeService().insertBoardNotice(bnotice);
		
		// 성공/실패 페이지 출력
		if(result > 0) {
			response.sendRedirect("bnlist?page=1");
			
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
