package board.notice.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardNoticeFileDownloadServlet
 */
@WebServlet("/bnfdown")
public class BoardNoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 게시글 첨부파일 다운로드 처리용 컨트롤러
		
		// 폴더 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/bn_upfiles");
		
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 파일명 추출
		String orgFilename = request.getParameter("ofile");
		String reFilename = request.getParameter("rfile");
		
		// 저장 폴더에서 파일 읽기용 스트림 생성
		File readFile = new File(savePath + "\\" + reFilename);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(readFile));
		
		// 클라이언트로 내보낼 출력용 스트림
		ServletOutputStream downOut = response.getOutputStream();
		
		// 한글 파일명
		response.setContentType("text/plain; charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String(orgFilename.getBytes("utf-8"), "ISO-8859-1") + "\"");
		response.setContentLength((int) readFile.length());
		
		// 파일 읽어서 내보내기
		int data = -1;
		while((data = bin.read()) != -1) {
			downOut.write(data);
			downOut.flush();
		}
		
		downOut.close();
		bin.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
