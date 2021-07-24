package trip.model.vo;

public class Trip implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
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

//	BLOG_NO
//	B_TITLE
//	B_NAME
//	B_THUMB
//	B_LINK
	
	private String blogNo;
	private String blogTitle;
	private String blogName;
	private String blogThumb;
	private String blogLink;
	
	//SNS용 객체
	public Trip(String blogNo, String blogTitle, String blogName, String blogThumb, String blogLink) {
		super();
		this.blogNo = blogNo;
		this.blogTitle = blogTitle;
		this.blogName = blogName;
		this.blogThumb = blogThumb;
		this.blogLink = blogLink;
	}
	
	//Trip용 객체
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

	
	public String getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(String blogNo) {
		this.blogNo = blogNo;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogThumb() {
		return blogThumb;
	}

	public void setBlogThumb(String blogThumb) {
		this.blogThumb = blogThumb;
	}

	public String getBlogLink() {
		return blogLink;
	}

	public void setBlogLink(String blogLink) {
		this.blogLink = blogLink;
	}

	@Override
	public String toString() {
		return "Trip [tripNo=" + tripNo + ", tripName=" + tripName + ", tripThumb=" + tripThumb + ", address=" + address
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", tripContent=" + tripContent + ", blogNo="
				+ blogNo + ", blogTitle=" + blogTitle + ", blogName=" + blogName + ", blogThumb=" + blogThumb
				+ ", blogLink=" + blogLink + "]";
	}
	
}
