package hotelDto;

import java.sql.Timestamp;

public class ReplyVo {
	private int qseq;
	private int pseq;
	private int replynum;
	private String content;
	private String email;
	private String name;
	private Timestamp indate;
	private String admin_delete;
	
	public ReplyVo() {
		
	}
	
	public ReplyVo(int qseq, int pseq, int replynum, String content, String email, String name, Timestamp indate, String admin_delete) {
		super();
		this.qseq = qseq;
		this.pseq = pseq;
		this.replynum = replynum;
		this.content = content;
		this.email = email;
		this.name = name;
		this.indate = indate;
		this.admin_delete = admin_delete;
	}


	public int getQseq() {
		return qseq;
	}


	public ReplyVo setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}

	public int getPseq() {
		return pseq;
	}

	public ReplyVo setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}

	public int getReplynum() {
		return replynum;
	}

	public ReplyVo setReplynum(int replynum) {
		this.replynum = replynum;
		return this;
	}

	public String getContent() {
		return content;
	}


	public ReplyVo setContent(String content) {
		this.content = content;
		return this;
	}


	public String getEmail() {
		return email;
	}


	public ReplyVo setEmail(String email) {
		this.email = email;
		return this;
	}


	public String getName() {
		return name;
	}


	public ReplyVo setName(String name) {
		this.name = name;
		return this;
	}


	public Timestamp getIndate() {
		return indate;
	}


	public ReplyVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	public String getAdmin_delete() {
		return admin_delete;
	}

	public ReplyVo setAdmin_delete(String admin_delete) {
		this.admin_delete = admin_delete;
		return this;
	}
	
	
}
