package board.ques.model.vo;

import java.sql.Date;

public class BoardQues implements java.io.Serializable {
	private static final long serialVersionUID = 3L;
	
	private int bqNo;
	private String bqType;
	private String bqWriter;
	private String bqTitle;
	private String bqContent;
	private java.sql.Date bqDate;
	private String orgFilename;
	private String reFilename;
	private int bqView;
	private int bqLike;
	private int repCount;
	
	public BoardQues() {}

	public BoardQues(int bqNo, String bqType, String bqWriter, String bqTitle, String bqContent, Date bqDate,
			String orgFilename, String reFilename, int bqView, int bqLike, int repCount) {
		super();
		this.bqNo = bqNo;
		this.bqType = bqType;
		this.bqWriter = bqWriter;
		this.bqTitle = bqTitle;
		this.bqContent = bqContent;
		this.bqDate = bqDate;
		this.orgFilename = orgFilename;
		this.reFilename = reFilename;
		this.bqView = bqView;
		this.bqLike = bqLike;
		this.repCount = repCount;
	}

	public BoardQues(int bqNo, String bqType, String bqWriter, String bqTitle, String bqContent, Date bqDate) {
		super();
		this.bqNo = bqNo;
		this.bqType = bqType;
		this.bqWriter = bqWriter;
		this.bqTitle = bqTitle;
		this.bqContent = bqContent;
		this.bqDate = bqDate;
	}

	public int getBqNo() {
		return bqNo;
	}

	public void setBqNo(int bqNo) {
		this.bqNo = bqNo;
	}

	public String getBqType() {
		return bqType;
	}

	public void setBqType(String bqType) {
		this.bqType = bqType;
	}

	public String getBqWriter() {
		return bqWriter;
	}

	public void setBqWriter(String bqWriter) {
		this.bqWriter = bqWriter;
	}

	public String getBqTitle() {
		return bqTitle;
	}

	public void setBqTitle(String bqTitle) {
		this.bqTitle = bqTitle;
	}

	public String getBqContent() {
		return bqContent;
	}

	public void setBqContent(String bqContent) {
		this.bqContent = bqContent;
	}

	public java.sql.Date getBqDate() {
		return bqDate;
	}

	public void setBqDate(java.sql.Date bqDate) {
		this.bqDate = bqDate;
	}

	public String getOrgFilename() {
		return orgFilename;
	}

	public void setOrgFilename(String orgFilename) {
		this.orgFilename = orgFilename;
	}

	public String getReFilename() {
		return reFilename;
	}

	public void setReFilename(String reFilename) {
		this.reFilename = reFilename;
	}

	public int getBqView() {
		return bqView;
	}

	public void setBqView(int bqView) {
		this.bqView = bqView;
	}

	public int getBqLike() {
		return bqLike;
	}

	public void setBqLike(int bqLike) {
		this.bqLike = bqLike;
	}

	public int getRepCount() {
		return repCount;
	}

	public void setRepCount(int repCount) {
		this.repCount = repCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardQues [bqNo=" + bqNo + ", bqType=" + bqType + ", bqWriter=" + bqWriter + ", bqTitle=" + bqTitle
				+ ", bqContent=" + bqContent + ", bqDate=" + bqDate + ", orgFilename=" + orgFilename + ", reFilename="
				+ reFilename + ", bqView=" + bqView + ", bqLike=" + bqLike + ", repCount=" + repCount + "]";
	}
	
	
	
}
