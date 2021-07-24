package trip.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trip.model.service.TripService;
import trip.model.vo.Trip;

/**
 * Servlet implementation class TripToScrap
 */
@WebServlet("/ttoscrap")
public class TripToScrap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TripToScrap() {
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
		String scList = request.getParameter("scstr");
		//System.out.println(scList);
		
		TripService service = new TripService();

		ArrayList<Trip> tlist = service.selecttScrapList(scList);

		RequestDispatcher view = null;
		if (tlist.size() > 0) {
			view = request.getRequestDispatcher("views/trip/scrapView.jsp");

			request.setAttribute("tlist", tlist);
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
