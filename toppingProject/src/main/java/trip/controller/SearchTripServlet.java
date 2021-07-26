package trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trip.model.service.TripService;
import trip.model.vo.Trip;

/**
 * Servlet implementation class searchTripServlet
 */
@WebServlet("/tlist")
public class SearchTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchTripServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		String regName = "";
		if (request.getParameter("searchTrip") != null) {
			regName = request.getParameter("searchTrip");
		}
		
		TripService service = new TripService();

		ArrayList<Trip> tlist = service.selecttList(regName);

		ArrayList<Trip> slist = service.selectsList(regName);
		
		// 뷰 지정해서 내보내기
		RequestDispatcher view = null;
		if (tlist.size() > 0) {
			view = request.getRequestDispatcher("views/trip/tripView.jsp");

			request.setAttribute("tlist", tlist);
			request.setAttribute("slist", slist);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", regName + "여행 목록이 없습니다.");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
