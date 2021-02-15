package hotelDto;

import java.sql.Timestamp;

public class PenguinBoardVo {

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
	private String mainyn;
	
	public PenguinBoardVo() {
		
	}
	
	public PenguinBoardVo
	(int num, int readcount, String subject, String content, String content2, String image1, String image2, String image3, String email, Timestamp indate, String mainyn) {
		
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
		this.mainyn = mainyn;
	}
	
	public int getNum() {
		return num;
	}
	
	public PenguinBoardVo setNum(int num) {
		this.num = num;
		return this;
	}
	
	public int getReadcount() {
		return readcount;
	}

	public PenguinBoardVo setReadcount(int readcount) {
		this.readcount = readcount;
		return this;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public PenguinBoardVo setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	
	public String getContent() {
		return content;
	}
	
	public PenguinBoardVo setContent(String content) {
		this.content = content;
		return this;
	}
	
	public String getContent2() {
		return content2;
	}

	public PenguinBoardVo setContent2(String content2) {
		this.content2 = content2;
		return this;
	}

	public String getImage1() {
		return image1;
	}
	
	public PenguinBoardVo setImage1(String image1) {
		this.image1 = image1;
		return this;
	}
	
	public String getImage2() {
		return image2;
	}
	
	public PenguinBoardVo setImage2(String image2) {
		this.image2 = image2;
		return this;
	}
	
	public String getImage3() {
		return image3;
	}
	
	public PenguinBoardVo setImage3(String image3) {
		this.image3 = image3;
		return this;
	}
	
	public String getEmail() {
		return email;
	}

	public PenguinBoardVo setEmail(String email) {
		this.email = email;
		return this;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public PenguinBoardVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	public String getMainyn() {
		return mainyn;
	}

	public PenguinBoardVo setMainyn(String mainyn) {
		this.mainyn = mainyn;
		return this;
	}
	
}
