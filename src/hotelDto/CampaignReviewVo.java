package hotelDto;

import java.sql.Timestamp;

public class CampaignReviewVo {
	private int qseq;				//번호
	private String subject;			//제목
	private String content;			//내용
	private String reply;
	private String email;			//작성자이메일
	private String name;			//작성자이름
	private int views;				//조회수
	private Timestamp indate;		//작성일
	private Timestamp edit_indate;	//수정일
	
	public CampaignReviewVo() {
			
	}
		
	public CampaignReviewVo(int qseq, String subject, String content, String reply, String email, String name, int views, Timestamp indate, Timestamp edit_indate) {
		this.qseq = qseq;
		this.subject = subject;
		this.content = content;
		this.reply = reply;
		this.email = email;
		this.name = name;
		this.views = views;
		this.indate = indate;
		this.edit_indate = edit_indate;
	}
	
	public int getQseq() {
		return qseq;
	}

	public CampaignReviewVo setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public CampaignReviewVo setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public String getContent() {
		return content;
	}

	public CampaignReviewVo setContent(String content) {
		this.content = content;
		return this;
	}

	public String getReply() {
		return reply;
	}

	public CampaignReviewVo setReply(String reply) {
		this.reply = reply;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CampaignReviewVo setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return name;
	}

	public CampaignReviewVo setName(String name) {
		this.name = name;
		return this;
	}

	public int getViews() {
		return views;
	}

	public CampaignReviewVo setViews(int views) {
		this.views = views;
		return this;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public CampaignReviewVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	public Timestamp getEdit_indate() {
		return edit_indate;
	}

	public CampaignReviewVo setEdit_indate(Timestamp edit_indate) {
		this.edit_indate = edit_indate;
		return this;
	}
	
}
