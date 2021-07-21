package board.ques.controller;

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
 * Servlet implementation class BoardQuesFileDownloadServlet
 */
@WebServlet("/bqfdown")
public class BoardQuesFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardQuesFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 질문 게시판 게시글 첨부파일 다운로드 처리용 컨트롤러
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/bq_upfiles");
		
		request.setCharacterEncoding("utf-8");
		
		String orgFilename = request.getParameter("ofile");
		String reFilename = request.getParameter("rfile");
		
		File readFile = new File(savePath + "\\" + reFilename);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(readFile));
		
		ServletOutputStream downOut = response.getOutputStream();
		
		response.setContentType("text/plain; charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String(orgFilename.getBytes("utf-8"), "ISO-8859-1") + "\"");
		response.setContentLength((int) readFile.length());
		
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
