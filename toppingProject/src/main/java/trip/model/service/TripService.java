package trip.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import trip.model.dao.TripDao;
import trip.model.vo.Trip;

public class TripService {
	
	private TripDao tdao = new TripDao();
	
	public ArrayList<Trip> selectList(String regName) {
		Connection conn = getConnection();
		ArrayList<Trip> list = tdao.selectList(conn, regName);
		close(conn);
		return list;
	}
}
