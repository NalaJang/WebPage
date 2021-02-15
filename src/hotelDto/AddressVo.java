package hotelDto;

public class AddressVo {
	
	private int seq;
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String ri;
	private String bldg;
	private String bunji;
	
	public AddressVo() {
		
	}
	
	public AddressVo(int seq, String zipcode, String sido, String gugun, String dong, String ri, String bldg,
			String bunji) {
		
		this.seq = seq;
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.ri = ri;
		this.bldg = bldg;
		this.bunji = bunji;
	}

	public int getSeq() {
		return seq;
	}

	public AddressVo setSeq(int seq) {
		this.seq = seq;
		return this;
	}

	public String getZipcode() {
		return zipcode;
	}

	public AddressVo setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}

	public String getSido() {
		return sido;
	}

	public AddressVo setSido(String sido) {
		this.sido = sido;
		return this;
	}

	public String getGugun() {
		return gugun;
	}

	public AddressVo setGugun(String gugun) {
		this.gugun = gugun;
		return this;
	}

	public String getDong() {
		return dong;
	}

	public AddressVo setDong(String dong) {
		this.dong = dong;
		return this;
	}

	public String getRi() {
		return ri;
	}

	public AddressVo setRi(String ri) {
		this.ri = ri;
		return this;
	}

	public String getBldg() {
		return bldg;
	}

	public AddressVo setBldg(String bldg) {
		this.bldg = bldg;
		return this;
	}

	public String getBunji() {
		return bunji;
	}

	public AddressVo setBunji(String bunji) {
		this.bunji = bunji;
		return this;
	}
	
	
	
}
