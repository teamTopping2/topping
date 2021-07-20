package board.notice.model.vo;

import java.sql.Date;

public class BoardNotice implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int bnNo;
	private String bnWriter;
	private String bnTitle;
	private String bnContent;
	private Date bnDate;
	private String orgFilename;
	private String reFilename;
	private int bnView;
	private int bnLike;
	
	public BoardNotice() {}
	
	public BoardNotice(int bnNo, String bnWriter, String bnTitle, String bnContent, Date bnDate, String orgFilename,
			String reFilename, int bnView, int bnLike) {
		super();
		this.bnNo = bnNo;
		this.bnWriter = bnWriter;
		this.bnTitle = bnTitle;
		this.bnContent = bnContent;
		this.bnDate = bnDate;
		this.orgFilename = orgFilename;
		this.reFilename = reFilename;
		this.bnView = bnView;
		this.bnLike = bnLike;
	}
	
	public BoardNotice(int bnNo, String bnWriter, String bnTitle, String bnContent) {
		super();
		this.bnNo = bnNo;
		this.bnWriter = bnWriter;
		this.bnTitle = bnTitle;
		this.bnContent = bnContent;
	}

	public int getBnNo() {
		return bnNo;
	}
	public void setBnNo(int bnNo) {
		this.bnNo = bnNo;
	}
	public String getBnWriter() {
		return bnWriter;
	}
	public void setBnWriter(String bnWriter) {
		this.bnWriter = bnWriter;
	}
	public String getBnTitle() {
		return bnTitle;
	}
	public void setBnTitle(String bnTitle) {
		this.bnTitle = bnTitle;
	}
	public String getBnContent() {
		return bnContent;
	}
	public void setBnContent(String bnContent) {
		this.bnContent = bnContent;
	}
	public Date getBnDate() {
		return bnDate;
	}
	public void setBnDate(Date bnDate) {
		this.bnDate = bnDate;
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
	public int getBnView() {
		return bnView;
	}
	public void setBnView(int bnView) {
		this.bnView = bnView;
	}
	public int getBnLike() {
		return bnLike;
	}
	public void setBnLike(int bnLike) {
		this.bnLike = bnLike;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardNotice [bnNo=" + bnNo + ", bnWriter=" + bnWriter + ", bnTitle=" + bnTitle + ", bnContent="
				+ bnContent + ", bnDate=" + bnDate + ", orgFilename=" + orgFilename + ", reFilename=" + reFilename
				+ ", bnView=" + bnView + ", bnLike=" + bnLike + "]";
	}
	
	
	
}
