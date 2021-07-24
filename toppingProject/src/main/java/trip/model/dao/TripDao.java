package trip.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import trip.model.vo.Trip;

public class TripDao {

	public ArrayList<Trip> selecttList(Connection conn, String regName) {
		ArrayList<Trip> list = new ArrayList<Trip>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from tb_trip where trip_no like '%' || (select reg_no from tb_region where reg_name like '%' || ? ||'%') || '%'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regName);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Trip trip = new Trip();

				trip.setTripNo(rset.getString("TRIP_NO"));
				trip.setTripName(rset.getString("TRIP_NAME"));
				trip.setTripThumb(rset.getString("TRIP_THUMB"));
				trip.setAddress(rset.getString("ADDRESS"));
				trip.setLatitude(rset.getDouble("LATITUDE"));
				trip.setLongitude(rset.getDouble("LONGITUDE"));
				trip.setTripContent(rset.getString("TRIP_CONTENT"));
				list.add(trip);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Trip> selectsList(Connection conn, String regName) {
		ArrayList<Trip> list = new ArrayList<Trip>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from tb_sns where blog_no like '%' || (select reg_no from tb_region where reg_name like '%' || ? ||'%') || '%'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, regName);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Trip trip = new Trip();

//				BLOG_NO
//				B_TITLE
//				B_NAME
//				B_THUMB
//				B_LINK

				trip.setBlogNo(rset.getString("BLOG_NO"));
				trip.setBlogTitle(rset.getString("B_TITLE"));
				trip.setBlogName(rset.getString("B_NAME"));
				trip.setBlogThumb(rset.getString("B_THUMB"));
				trip.setBlogLink(rset.getString("B_LINK"));
				
				list.add(trip);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Trip> selecttScrapList(Connection conn, String scList) {
		ArrayList<Trip> list = new ArrayList<Trip>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = String.format("select * from tb_trip where trip_no in(%s)",scList);
		// "select * from tb_trip where trip_no(?)";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while (rset.next()) {
				Trip trip = new Trip();

				trip.setTripNo(rset.getString("TRIP_NO"));
				trip.setTripName(rset.getString("TRIP_NAME"));
				trip.setTripThumb(rset.getString("TRIP_THUMB"));
				trip.setAddress(rset.getString("ADDRESS"));
				trip.setLatitude(rset.getDouble("LATITUDE"));
				trip.setLongitude(rset.getDouble("LONGITUDE"));
				trip.setTripContent(rset.getString("TRIP_CONTENT"));
				
				list.add(trip);
			}

		} catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}
}
