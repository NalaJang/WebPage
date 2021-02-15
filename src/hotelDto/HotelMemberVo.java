package hotelDto;

import java.sql.Timestamp;

//JavaBean
public class HotelMemberVo { // JavaBean Object(VO, DTO)
	private int no;
	private String name;      //필드 속성 프로펄티 객체  : 다 같은말
	private String phone;
	private String pw;
	private String zip_num;
	private String address1;
	private String address2;
	private String email;
	private String useyn;
	private Timestamp indate;
	
	public HotelMemberVo() {}

	public HotelMemberVo
	(int no, String name, String phone, String pw, String zip_num, String address1, String address2, String email, String useyn, Timestamp indate) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.pw = pw;
		this.zip_num = zip_num;
		this.address1 = address1;
		this.address2 = address2;
		this.email = email;
		this.useyn = useyn;
		this.indate = indate;
	}

	public int getNo() {
		return no;
	}

	public HotelMemberVo setNo(int no) {
		this.no = no;
		return this;
	}

	public String getName() {
		return name;
	}

	public HotelMemberVo setName(String name) {
		this.name = name;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public HotelMemberVo setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getPw() {
		return pw;
	}

	public HotelMemberVo setPw(String pw) {
		this.pw = pw;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public HotelMemberVo setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public HotelMemberVo setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public HotelMemberVo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getZip_num() {
		return zip_num;
	}

	public HotelMemberVo setZip_num(String zip_num) {
		this.zip_num = zip_num;
		return this;
	}

	public String getUseyn() {
		return useyn;
	}

	public HotelMemberVo setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public HotelMemberVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	

}
