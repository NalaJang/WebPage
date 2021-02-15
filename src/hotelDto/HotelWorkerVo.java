package hotelDto;

public class HotelWorkerVo {
	private String email;
	private String pw;
	private String name;
	private String phone;
	
	public HotelWorkerVo(){
		
	}
	
	public HotelWorkerVo(String email, String pw, String name, String phone) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		
	}
	public String getEmail() {
		return email;
	}
	public HotelWorkerVo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPw() {
		return pw;
	}
	public HotelWorkerVo setPw(String pw) {
		this.pw = pw;
		return this;
	}
	public String getName() {
		return name;
	}
	public HotelWorkerVo setName(String name) {
		this.name = name;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public HotelWorkerVo setPhone(String phone) {
		this.phone = phone;
		return this;
	}
}
