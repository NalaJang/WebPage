package hotelDto;

import java.sql.Timestamp;

public class OrderVo {
	private int odseq;
	private int oseq;
	private String email;	
	private Timestamp indate;
	private int pseq;
	private int quantity;
	private String mname;
	private String zip_num;
	private String phone;
	private String address1;
	private String address2;
	private String pname;
	private int price2;
	private String image1;
	private String result;
	
	public OrderVo(){
		
	}
	public OrderVo
	(int odseq, int oseq, Timestamp indate, int pseq, int quantity, String mname, String zip_num, String phone, String address1, String address2, String pname, int price2, String image1, String result){
		this.odseq = odseq;
		this.oseq = oseq;
		this.indate = indate;
		this.pseq = pseq;
		this.quantity = quantity;
		this.mname = mname;
		this.zip_num = zip_num;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.pname = pname;
		this.price2 = price2;
		this.image1 = image1;
		this.result = result;
		
	}
	
	public int getOdseq() {
		return odseq;
	}
	
	public OrderVo setOdseq(int odseq) {
		this.odseq = odseq;
		return this;
	}
	
	public int getOseq() {
		return oseq;
	}
	
	public OrderVo setOseq(int oseq) {
		this.oseq = oseq;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public OrderVo setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public Timestamp getIndate() {
		return indate;
	}
	
	public OrderVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	
	public int getPseq() {
		return pseq;
	}
	
	public OrderVo setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public OrderVo setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public String getMname() {
		return mname;
	}
	
	public OrderVo setMname(String mname) {
		this.mname = mname;
		return this;
	}
	
	public String getZip_num() {
		return zip_num;
	}
	
	public OrderVo setZip_num(String zip_num) {
		this.zip_num = zip_num;
		return this;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public OrderVo setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public OrderVo setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public OrderVo setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	
	public String getPname() {
		return pname;
	}
	
	public OrderVo setPname(String pname) {
		this.pname = pname;
		return this;
	}
	
	public int getPrice2() {
		return price2;
	}
	
	public OrderVo setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	
	public String getImage1() {
		return image1;
	}
	
	public OrderVo setImage1(String image1) {
		this.image1 = image1;
		return this;
	}
	
	public String getResult() {
		return result;
	}
	
	public OrderVo setResult(String result) {
		this.result = result;
		return this;
	}
}
