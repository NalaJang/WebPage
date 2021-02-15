package hotelDto;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationVo2 {
	
	private int rvseq;			//예약번호
	private String email;		//이메일
	private Timestamp indate;   //예약시간
	private int rseq;			//예약한 룸번호
	private int membernum;		//인원수
	private String mname;		//예약자 정보
	private String phone;
	private String zip_num;
	private String address1;
	private String address2;
	private String rkind;		//룸 종류
	private String rentyn;		//자동차 렌트 유무
	private Date checkin;		//체크인 날짜
	private Date checkout;		//체크아웃 날짜
	private int price;			//가격
	private int donation;		//후원금
	private String result;		//default '1'
	
	public ReservationVo2() {
		
	}
	
	public ReservationVo2
	(int rvseq, String email, Timestamp indate, int rseq, int membernum, 
			String mname, String phone, String zip_num, String address1, String address2, String rkind, String rentyn, Date checkin, Date checkout, int price, int donation, String result) {
		
		this.rvseq = rvseq;
		this.email = email;
		this.indate = indate;
		this.rseq = rseq;
		this.membernum = membernum;
		this.mname = mname;
		this.phone = phone;
		this.zip_num = zip_num;
		this.address1 = address1;
		this.address2 = address2;
		this.rkind = rkind;
		this.rentyn = rentyn;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
		this.donation = donation;
		this.result = result;
	}
	
	public int getRvseq() {
		return rvseq;
	}

	public ReservationVo2 setRvseq(int rvseq) {
		this.rvseq = rvseq;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ReservationVo2 setEmail(String email) {
		this.email = email;
		return this;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public ReservationVo2 setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	public int getRseq() {
		return rseq;
	}

	public ReservationVo2 setRseq(int rseq) {
		this.rseq = rseq;
		return this;
	}

	public int getMembernum() {
		return membernum;
	}

	public ReservationVo2 setMembernum(int membernum) {
		this.membernum = membernum;
		return this;
	}

	public String getMname() {
		return mname;
	}

	public ReservationVo2 setMname(String mname) {
		this.mname = mname;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public ReservationVo2 setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getZip_num() {
		return zip_num;
	}

	public ReservationVo2 setZip_num(String zip_num) {
		this.zip_num = zip_num;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public ReservationVo2 setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public ReservationVo2 setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getRkind() {
		return rkind;
	}

	public ReservationVo2 setRkind(String rkind) {
		this.rkind = rkind;
		return this;
	}

	public String getRentyn() {
		return rentyn;
	}

	public ReservationVo2 setRentyn(String rentyn) {
		this.rentyn = rentyn;
		return this;
	}

	public Date getCheckin() {
		return checkin;
	}

	public ReservationVo2 setCheckin(Date checkin) {
		this.checkin = checkin;
		return this;
	}

	public Date getCheckout() {
		return checkout;
	}

	public ReservationVo2 setCheckout(Date checkout) {
		this.checkout = checkout;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public ReservationVo2 setPrice(int price) {
		this.price = price;
		return this;
	}

	public int getDonation() {
		return donation;
	}

	public ReservationVo2 setDonation(int donation) {
		this.donation = donation;
		return this;
	}

	public String getResult() {
		return result;
	}

	public ReservationVo2 setResult(String result) {
		this.result = result;
		return this;
	}
	
}
