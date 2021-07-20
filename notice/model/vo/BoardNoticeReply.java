package board.notice.model.vo;

import java.sql.Date;

public class BoardNoticeReply implements java.io.Serializable {
	private static final long serialVersionUID = 2L;
	
	private int bnNo;
	private int comNo;
	private String comWriter;
	private String comContent;
	private java.sql.Date comDate;
	
	public BoardNoticeReply() {}
	
	public BoardNoticeReply(int bnNo, int comNo, String comWriter, String comContent, Date comDate) {
		super();
		this.bnNo = bnNo;
		this.comNo = comNo;
		this.comWriter = comWriter;
		this.comContent = comContent;
		this.comDate = comDate;
	}

	public BoardNoticeReply(int bnNo, int comNo, String comWriter, String comContent) {
		super();
		this.bnNo = bnNo;
		this.comNo = comNo;
		this.comWriter = comWriter;
		this.comContent = comContent;
	}

	public int getBnNo() {
		return bnNo;
	}

	public void setBnNo(int bnNo) {
		this.bnNo = bnNo;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public String getComWriter() {
		return comWriter;
	}

	public void setComWriter(String comWriter) {
		this.comWriter = comWriter;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public java.sql.Date getComDate() {
		return comDate;
	}

	public void setComDate(java.sql.Date comDate) {
		this.comDate = comDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardNoticeReply [bnNo=" + bnNo + ", comNo=" + comNo + ", comWriter=" + comWriter + ", comContent="
				+ comContent + ", comDate=" + comDate + "]";
	}
	
	
	
}
