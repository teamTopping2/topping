package trip.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import trip.model.vo.Trip;

public class TripDao {

	public ArrayList<Trip> selectList(Connection conn, String regName) {
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

//				TRIP_NO
//				TRIP_NAME
//				TRIP_THUMB
//				ADDRESS
//				LATITUDE
//				LONGITUDE
//				TRIP_CONTENT

//				private int tripNo;
//				private String tripName;
//				private String tripThumb;
//				private String address;
//				private Double latitude;
//				private Double longitude;
//				private String tripContent;

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
}
