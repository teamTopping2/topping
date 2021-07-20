package board.ques.model.vo;

import java.sql.Date;

public class BoardQuesReply implements java.io.Serializable {
	private final static long serialVersionUID = 4L;
	
	private int bqNo;
	private int comNo;
	private String comWriter;
	private String comContent;
	private java.sql.Date comDate;
	
	public BoardQuesReply() {}

	public BoardQuesReply(int bqNo, int comNo, String comWriter, String comContent, Date comDate) {
		super();
		this.bqNo = bqNo;
		this.comNo = comNo;
		this.comWriter = comWriter;
		this.comContent = comContent;
		this.comDate = comDate;
	}

	public int getBqNo() {
		return bqNo;
	}

	public void setBqNo(int bqNo) {
		this.bqNo = bqNo;
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
		return "BoardQuesReply [bqNo=" + bqNo + ", comNo=" + comNo + ", comWriter=" + comWriter + ", comContent="
				+ comContent + ", comDate=" + comDate + "]";
	}
	
	
	
}
