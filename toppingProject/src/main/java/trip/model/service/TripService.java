package trip.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import trip.model.dao.TripDao;
import trip.model.vo.Trip;

public class TripService {

	private TripDao tdao = new TripDao();

	public ArrayList<Trip> selecttList(String regName) {
		Connection conn = getConnection();
		ArrayList<Trip> list = tdao.selecttList(conn, regName);
		close(conn);
		return list;
	}

	public ArrayList<Trip> selectsList(String regName) {
		Connection conn = getConnection();
		ArrayList<Trip> list = tdao.selectsList(conn, regName);
		close(conn);
		return list;
	}

	public ArrayList<Trip> selecttScrapList(String scList) {
		Connection conn = getConnection();
		ArrayList<Trip> list = tdao.selecttScrapList(conn, scList);
		close(conn);
		return list;
	}
}
