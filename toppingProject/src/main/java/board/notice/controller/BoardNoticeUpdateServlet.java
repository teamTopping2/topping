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
 * Servlet implementation class BoardNoticeUpdateServlet
 */
@WebServlet("/bnupdate")
public class BoardNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 게시판 게시글 수정 처리용 컨트롤러

		// 인코딩 됐는지 확인 -> 안 됐으면 에러 페이지 출력
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype 속성이 누락됐습니다");
			view.forward(request, response);
		}

		// 업로드할 파일의 용량 제한: 100MB
		int maxSize = 1024 * 1024 * 100;

		// 저장 폴더 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/bn_upfiles");

		// MultipartRequest 변환
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());

		// 값 추출
		BoardNotice bnotice = new BoardNotice();
		
		bnotice.setBnNo(Integer.parseInt(mrequest.getParameter("bnNo")));
		bnotice.setBnTitle(mrequest.getParameter("title"));
		bnotice.setBnWriter(mrequest.getParameter("writer"));
		bnotice.setBnContent(mrequest.getParameter("content"));
		
		int currentPage = Integer.parseInt(mrequest.getParameter("page"));
		
		// 이전 첨부파일
		String deleteFile = mrequest.getParameter("deleteFile");
		String orgFilePath = mrequest.getParameter("ofile");
		String reFilePath = mrequest.getParameter("rfile");
		
		// 새로운 첨부파일
		String originalFilename = mrequest.getFilesystemName("upfile");
		
		File newOrgFile = new File(savePath + "\\" + originalFilename);
		File orgFile = new File(savePath + "\\" + reFilePath);
		
		// 기존 게시글의 첨부파일 수정 및 첨가
		if(originalFilename != null) {
			bnotice.setOrgFilename(originalFilename);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String reFilename = sdf.format(new java.sql.Date(System.currentTimeMillis()));

			reFilename += originalFilename.substring(originalFilename.lastIndexOf("."));
			
			File renameFile = new File(savePath + "\\" + reFilename);
			
			if (!newOrgFile.renameTo(renameFile)) { // 수동으로 이름 바꾸기
				FileInputStream fin = new FileInputStream(newOrgFile);
				FileOutputStream fout = new FileOutputStream(renameFile);

				int data = -1;
				byte[] buffer = new byte[1024];

				while ((data = fin.read(buffer, 0, buffer.length)) != -1) {
					fout.write(buffer, 0, buffer.length);
				}

				fin.close();
				fout.close();
				newOrgFile.delete();
				
			} // if: 수동으로 이름 변경
			
			bnotice.setReFilename(reFilename);
			
			// 이전 첨부파일 삭제
			if(orgFile != null) {
				orgFile.delete();
			}
			
		} else if (orgFilePath != null && deleteFile != null && deleteFile.equals("yse")) {
			bnotice.setOrgFilename(null);
			bnotice.setReFilename(null);
			
			orgFile.delete();
			
		} else if (orgFilePath != null && (originalFilename != null || orgFilePath.equals(originalFilename) && newOrgFile.length() == orgFile.length())) {
			bnotice.setOrgFilename(orgFilePath);
			bnotice.setReFilename(reFilePath);
		}

		// 서비스 메소드로 전달하고 결과 받기
		int result = new BoardNoticeService().updatBoardNotice(bnotice);

		// 성공/실패 페이지 출력
		if (result > 0) {
			response.sendRedirect("bndetail?bnNo=" + bnotice.getBnNo() + "&page=" + currentPage);

		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", bnotice.getBnNo() + "번 게시글 수정 실패");
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
