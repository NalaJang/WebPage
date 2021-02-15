package hotelDto;

import java.util.Date;

public class NoticeVo {
	private int id;
	private String title;
	private String writerId;
	private Date regdate;
	private String hit;
	private String files;
	private String content;
	
	public NoticeVo() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeVo(int id, String title, String writerId, Date regdate, String hit, String files, String content) {
		
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}


	public int getId() {
		return id;
	}
	
	public NoticeVo setId(int id) {
		this.id = id;
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	
	public NoticeVo setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getWriterId() {
		return writerId;
	}
	
	public NoticeVo setWriterId(String writerId) {
		this.writerId = writerId;
		return this;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public NoticeVo setRegdate(Date regdate) {
		this.regdate = regdate;
		return this;
	}
	
	public String getHit() {
		return hit;
	}
	
	public NoticeVo setHit(String hit) {
		this.hit = hit;
		return this;
	}
	
	public String getFiles() {
		return files;
	}
	
	public NoticeVo setFiles(String files) {
		this.files = files;
		return this;
	}
	
	public String getContent() {
		return content;
	}
	
	public NoticeVo setContent(String content) {
		this.content = content;
		return this;
	}
}
