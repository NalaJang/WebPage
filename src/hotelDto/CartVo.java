package hotelDto;

import java.sql.Timestamp;

public class CartVo {
	private int cseq;		//번호
	private String email;	//이메일
	private String mname;	//주문자
	private int pseq;		//상품번호
	private String pname;	//상품명
	private int quantity;	//수량
	private int price2;		//가격
	private String result;	//처리결과 default = '1'
	private Timestamp indate;//카트에 담긴 시간
	private String image1;	//상품 이미지
	
	
	public CartVo (){
		
	}
	
	public CartVo(int cseq, String email, String mname, int pseq, String pname, int quantity, int price2, String result, Timestamp indate, String image1){
		this.cseq = cseq;
		this.email = email;
		this.mname = mname;
		this.pseq = pseq;
		this.pname = pname;
		this.quantity = quantity;
		this.price2 = price2;
		this.result = result;
		this.indate = indate;
		this.image1 = image1;
	}
	public int getCseq() {
		return cseq;
	}
	public CartVo setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public CartVo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getMname() {
		return mname;
	}
	public CartVo setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public CartVo setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public CartVo setPname(String pname) {
		this.pname = pname;
		return this;
	}
	public int getQuantity() {
		return quantity;
	}
	public CartVo setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public CartVo setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public String getResult() {
		return result;
	}
	public CartVo setResult(String result) {
		this.result = result;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public CartVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	public String getImage1() {
		return image1;
	}

	public CartVo setImage1(String image1) {
		this.image1 = image1;
		return this;
	}	
	
}
