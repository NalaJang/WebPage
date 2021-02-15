package hotelDto;

import java.sql.Timestamp;

public class CampaignVo {

	private int num;
	private int readcount;
	private String subject;
	private String content;
	private String content2;
	private String image1;
	private String image2;
	private String image3;
	private String email;
	private Timestamp indate;
	
	public CampaignVo() {
		
	}
	
	public CampaignVo
	(int num, int readcount, String subject, String content, String content2, String image1, String image2, String image3, String email, Timestamp indate) {
		
		this.num = num;
		this.readcount = readcount;
		this.subject = subject;
		this.content = content;
		this.content2 = content2;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.email = email;
		this.indate = indate;
	}
	
	public int getNum() {
		return num;
	}
	
	public CampaignVo setNum(int num) {
		this.num = num;
		return this;
	}
	
	public int getReadcount() {
		return readcount;
	}

	public CampaignVo setReadcount(int readcount) {
		this.readcount = readcount;
		return this;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public CampaignVo setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	
	public String getContent() {
		return content;
	}
	
	public CampaignVo setContent(String content) {
		this.content = content;
		return this;
	}
	
	public String getContent2() {
		return content2;
	}

	public CampaignVo setContent2(String content2) {
		this.content2 = content2;
		return this;
	}

	public String getImage1() {
		return image1;
	}
	
	public CampaignVo setImage1(String image1) {
		this.image1 = image1;
		return this;
	}
	
	public String getImage2() {
		return image2;
	}
	
	public CampaignVo setImage2(String image2) {
		this.image2 = image2;
		return this;
	}
	
	public String getImage3() {
		return image3;
	}
	
	public CampaignVo setImage3(String image3) {
		this.image3 = image3;
		return this;
	}
	
	public String getEmail() {
		return email;
	}

	public CampaignVo setEmail(String email) {
		this.email = email;
		return this;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public CampaignVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	
}
