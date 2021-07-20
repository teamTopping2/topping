package trip.model.vo;

public class Trip implements java.io.Serializable{
	private static final long serialVersionUID = 113L;
	
//	TRIP_NO
//	TRIP_NAME
//	TRIP_THUMB
//	ADDRESS
//	LATITUDE
//	LONGITUDE
//	TRIP_CONTENT
	
	private String tripNo;
	private String tripName;
	private String tripThumb;
	private String address;
	private Double latitude;
	private Double longitude;
	private String tripContent;

	public Trip() {
		
	}
	
	public Trip(String tripNo, String tripName, String tripThumb, String tripContent) {
		super();
		this.tripNo = tripNo;
		this.tripName = tripName;
		this.tripThumb = tripThumb;
		this.tripContent = tripContent;
	}
	
	public Trip(String tripNo, String tripName, String tripThumb, String address, Double latitude, Double longitude,
			String tripContent) {
		super();
		this.tripNo = tripNo;
		this.tripName = tripName;
		this.tripThumb = tripThumb;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.tripContent = tripContent;
	}

	public String getTripNo() {
		return tripNo;
	}

	public void setTripNo(String tripNo) {
		this.tripNo = tripNo;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public String getTripThumb() {
		return tripThumb;
	}

	public void setTripThumb(String tripThumb) {
		this.tripThumb = tripThumb;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getTripContent() {
		return tripContent;
	}

	public void setTripContent(String tripContent) {
		this.tripContent = tripContent;
	}

	@Override
	public String toString() {
		return "Trip [tripNo=" + tripNo + ", tripName=" + tripName + ", tripThumb=" + tripThumb + ", address=" + address
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", tripContent=" + tripContent + "]";
	}
	
}
