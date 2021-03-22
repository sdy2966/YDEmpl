package common;

public class InputBoardVO {
	int boardNo;
	String title;
	String passwd;
	String publicity;
	String exitDate; 
	String contents;
	
	public InputBoardVO(int boardNo, String title, String passwd, String publicity, String exitDate, String contents) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.passwd = passwd;
		this.publicity = publicity;
		this.exitDate = exitDate;
		this.contents = contents;
	}
	public InputBoardVO() {
		// TODO Auto-generated constructor stub
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPublicity() {
		return publicity;
	}
	public void setPublicity(String publicity) {
		this.publicity = publicity;
	}
	public String getExitDate() {
		return exitDate;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
