package hotelDto;

import java.sql.Timestamp;

public class DonationVo {
	
	private int dnseq;
	private String name;
	private String email;
	private String phone;
	private int money;
	private int money2;
	private Timestamp indate;
	
	public DonationVo() {
	
	}
	
	public DonationVo(int dnseq, String name, String email, String phone, int money, int money2, Timestamp indate) {
		this.dnseq = dnseq;
		this.name= name;
		this.email = email;
		this.phone = phone;
		this.money = money;
		this.money2 = money2;
		this.indate = indate;
	}
	
	public int getDnseq() {
		return dnseq;
	}
	
	public DonationVo setDnseq(int dnseq) {
		this.dnseq = dnseq;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public DonationVo setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public DonationVo setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public DonationVo setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public int getMoney() {
		
		return money;
	}
	public DonationVo setMoney(int money) {
		this.money = money;
		return this;
	}
	
	public int getMoney2() {
		return money2;
	}

	public DonationVo setMoney2(int money2) {
		this.money2 = money2;
		return this;
	}

	public Timestamp getIndate() {
		return indate;
	}
	
	public DonationVo setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
}
