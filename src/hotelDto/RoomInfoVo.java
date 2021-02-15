package hotelDto;

import java.sql.Timestamp;

public class RoomInfoVo {
	private int rseq;	//번호	
	private String kind;	//객실 종류
	private int price;		//1인당 가격
	private String content;
	private String image1;	//객실 이미지
	private String image2;
	private String image3;
	private String image4;
	private String useyn;
	private Timestamp indate;
	private String detail;
	private int donation;
	
	public RoomInfoVo(){
		
	}
	
	public RoomInfoVo
	(int rseq, String kind, int price, String content, String image1, String image2, String image3, String image4, 
			String useyn, Timestamp indate, String detail, int donation){
		this.rseq = rseq;
		this.kind = kind;
		this.price = price;
		this.content = content;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.useyn = useyn;
		this.indate = indate;
		this.detail = detail;
		this.donation = donation;
	}

	public int getRseq() {
		return rseq;
	}

	public RoomInfoVo setRseq(int rseq) {
		this.rseq = rseq;
		return this;
	}

	public String getKind() {
		return kind;
	}

	public RoomInfoVo setKind(String kind) {
		this.kind = kind;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public RoomInfoVo setPrice(int price) {
		this.price = price;
		return this;
	}

	public String getContent() {
		return content;
	}

	public RoomInfoVo setContent(String content) {
		this.content = content;
		return this;
	}

	public String getImage1() {
		return image1;
	}

	public RoomInfoVo setImage1(String image1) {
		this.image1 = image1;
		return this;
	}

	public String getImage2() {
		return image2;
	}

	public RoomInfoVo setImage2(String image2) {
		this.image2 = image2;
		return this;
	}

	public String getImage3() {
		return image3;
	}

	public RoomInfoVo setImage3(String image3) {
		this.image3 = image3;
		return this;
	}

	public String getImage4() {
		return image4;
	}

	public RoomInfoVo setImage4(String image4) {
		this.image4 = image4;
		return this;
	}

	public String getUseyn() {
		return useyn;
	}

	public RoomInfoVo setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public RoomInfoVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	public String getDetail() {
		return detail;
	}

	public RoomInfoVo setDetail(String detail) {
		this.detail = detail;
		return this;
	}

	public int getDonation() {
		return donation;
	}

	public RoomInfoVo setDonation(int donation) {
		this.donation = donation;
		return this;
	}
	
	
	
}
