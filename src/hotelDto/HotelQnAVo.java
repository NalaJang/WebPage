package hotelDto;

import java.sql.Timestamp;

public class HotelQnAVo {
	private int qseq;	// 글 번호
	private String title;	//주제
	private String subject;	//제목
	private String content;	//문의내용
	private String reply;	//답변내용	
	private String email;	//작성자
	private String rep;		//1 : 답변 무 , 2: 답변 유
	private Timestamp indate;//작성시간
	private String reply_date;

	public HotelQnAVo(){
		
	}
	public HotelQnAVo(int qseq, String title, String subject, String content, String reply, String email, String rep, Timestamp indate, String reply_date) {
		this.qseq = qseq;
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.reply = reply;
		this.email = email;
		this.rep = rep;
		this.indate = indate;
		this.reply_date = reply_date;
		
	}
	public int getQseq() {
		return qseq;
	}
	public HotelQnAVo setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public HotelQnAVo setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public HotelQnAVo setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public HotelQnAVo setContent(String content) {
		this.content = content;
		return this;
	}
	public String getReply() {
		return reply;
	}
	public HotelQnAVo setReply(String reply) {
		this.reply = reply;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public HotelQnAVo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getRep() {
		return rep;
	}
	public HotelQnAVo setRep(String rep) {
		this.rep = rep;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public HotelQnAVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	public String getReply_date() {
		return reply_date;
	}
	public HotelQnAVo setReply_date(String reply_date) {
		this.reply_date = reply_date;
		return this;
	}
	
}
