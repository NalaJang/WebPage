package hotelDto;

import java.sql.Timestamp;

public class ProductVo {
	private int pseq;		//상품번호
	private String name;	//상품명
	private String kind;	//종류
	private int price1;		//할인된 가격
	private int price2;		//판매가격
	private String content;	//내용
	private String image1;	//이미지
	private String image2;
	private String image3;
	private String image4;
	private String useyn;	//노출여부
	private String bestyn;	//베스트상품
	private Timestamp indate;//상품 업데이트시간
	private String detail;	//상세정보
	private String detail2;
	private int stock;		//재고
	
	public ProductVo() {
		
	}
	
	public ProductVo
	(int pseq, String name, String kind, int price1, int price2, String content,
			String image1, String image2, String image3, String image4, String useyn, String bestyn, Timestamp indate, String detail, String detail2, int stock) {
		
		this.pseq = pseq;
		this.name = name;
		this.kind = kind;
		this.price1 = price1;
		this.price2 = price2;
		this.content = content;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.useyn = useyn;
		this.bestyn = bestyn;
		this.indate = indate;
		this.detail = detail;
		this.detail2 = detail2;
		this.stock = stock;
		
	}
	
	public int getPseq() {
		return pseq;
	}
	
	public ProductVo setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public ProductVo setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getKind() {
		return kind;
	}
	
	public ProductVo setKind(String kind) {
		this.kind = kind;
		return this;
	}
	
	public int getPrice1() {
		return price1;
	}
	
	public ProductVo setPrice1(int price1) {
		this.price1 = price1;
		return this;
	}
	
	public int getPrice2() {
		return price2;
	}
	
	public ProductVo setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	
	public String getContent() {
		return content;
	}
	
	public ProductVo setContent(String content) {
		this.content = content;
		return this;
	}
	
	public String getImage1() {
		return image1;
	}
	
	public ProductVo setImage1(String image1) {
		this.image1 = image1;
		return this;
	}
	
	public String getImage2() {
		return image2;
	}
	
	public ProductVo setImage2(String image2) {
		this.image2 = image2;
		return this;
	}
	
	public String getImage3() {
		return image3;
	}
	
	public ProductVo setImage3(String image3) {
		this.image3 = image3;
		return this;
	}
	
	public String getImage4() {
		return image4;
	}
	
	public ProductVo setImage4(String image4) {
		this.image4 = image4;
		return this;
	}
	
	public String getUseyn() {
		return useyn;
	}
	
	public ProductVo setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	
	public String getBestyn() {
		return bestyn;
	}
	
	public ProductVo setBestyn(String bestyn) {
		this.bestyn = bestyn;
		return this;
	}
	
	public Timestamp getIndate() {
		return indate;
	}
	
	public ProductVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public ProductVo setDetail(String detail) {
		this.detail = detail;
		return this;
	}

	public String getDetail2() {
		return detail2;
	}

	public ProductVo setDetail2(String detail2) {
		this.detail2 = detail2;
		return this;
	}

	public int getStock() {
		return stock;
	}

	public ProductVo setStock(int stock) {
		this.stock = stock;
		return this;
	}
	
	
}
