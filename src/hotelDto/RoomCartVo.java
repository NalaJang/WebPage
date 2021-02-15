package hotelDto;

import java.sql.Date;
import java.sql.Timestamp;

public class RoomCartVo {
	private int cseq;
	private int rseq;		//방번호
	private String email;	//이메일
	private String mname;	//주문자
	private String rkind;	//방종류
	private int membernum;	//인원수
	private Timestamp indate;//카트에 담긴 시간
	private Date checkin;
	private Date checkout;
	private String image1;	//상품 이미지
	private int price;		//가격
	private int donation;
	private String result;	//처리결과 default = '1'
	
	public RoomCartVo() {
		
	}

	public RoomCartVo
	(int cseq, int rseq, String email, String mname, String rkind, int membernum, Timestamp indate, Date checkin, Date checkout, 
			String image1, int price, int donation, String result) {
		
		this.cseq = cseq;
		this.rseq = rseq;
		this.email = email;
		this.mname = mname;
		this.rkind = rkind;
		this.membernum = membernum;
		this.indate = indate;
		this.checkin = checkin;
		this.checkout = checkout;
		this.image1 = image1;
		this.price = price;
		this.donation = donation;
		this.result = result;
		
	}

	public int getCseq() {
		return cseq;
	}

	public RoomCartVo setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}

	public int getRseq() {
		return rseq;
	}


	public RoomCartVo setRseq(int rseq) {
		this.rseq = rseq;
		return this;
	}


	public String getEmail() {
		return email;
	}


	public RoomCartVo setEmail(String email) {
		this.email = email;
		return this;
	}


	public String getMname() {
		return mname;
	}


	public RoomCartVo setMname(String mname) {
		this.mname = mname;
		return this;
	}


	public String getRkind() {
		return rkind;
	}


	public RoomCartVo setRkind(String rkind) {
		this.rkind = rkind;
		return this;
	}


	public int getMembernum() {
		return membernum;
	}


	public RoomCartVo setMembernum(int membernum) {
		this.membernum = membernum;
		return this;
	}


	public Timestamp getIndate() {
		return indate;
	}


	public RoomCartVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}


	public Date getCheckin() {
		return checkin;
	}


	public RoomCartVo setCheckin(Date checkin) {
		this.checkin = checkin;
		return this;
	}


	public Date getCheckout() {
		return checkout;
	}


	public RoomCartVo setCheckout(Date checkout) {
		this.checkout = checkout;
		return this;
	}


	public String getImage1() {
		return image1;
	}


	public RoomCartVo setImage1(String image1) {
		this.image1 = image1;
		return this;
	}


	public int getPrice() {
		return price;
	}


	public RoomCartVo setPrice(int price) {
		this.price = price;
		return this;
	}
	
	public int getDonation() {
		return donation;
	}

	public RoomCartVo setDonation(int donation) {
		this.donation = donation;
		return this;
	}

	public String getResult() {
		return result;
	}


	public RoomCartVo setResult(String result) {
		this.result = result;
		return this;
	}
	
	
}
