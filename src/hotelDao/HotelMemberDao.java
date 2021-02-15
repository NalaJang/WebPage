package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import hotelDto.AddressVo;
import hotelDto.HotelMemberVo;
import projectControls.Component;

@Component("memberDao")
public class HotelMemberDao implements HotelInfo {
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	//----------------------------------------------------------------
	//							회원 가입
	//----------------------------------------------------------------
	@Override
	public int insert(HotelMemberVo hotelMemberVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO HOTELMEMBER(NAME, EMAIL, PW, PHONE, ZIP_NUM, ADDRESS1, ADDRESS2) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, hotelMemberVo.getName());
			pstmt.setString(2, hotelMemberVo.getEmail());
			pstmt.setString(3, hotelMemberVo.getPw());
			pstmt.setString(4, hotelMemberVo.getPhone());
			pstmt.setString(5, hotelMemberVo.getZip_num());
			pstmt.setString(6, hotelMemberVo.getAddress1());
			pstmt.setString(7, hotelMemberVo.getAddress2());
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}

	//----------------------------------------------------------------
	//							주소 찾기
	//----------------------------------------------------------------
	@Override
	public ArrayList<AddressVo> address(String dong) throws Exception {
		ArrayList<AddressVo> address = new ArrayList<>();
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ZIPCODE WHERE DONG LIKE '%"+ dong +"%'");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AddressVo adVo = new AddressVo();
				adVo.setSeq(rs.getInt("seq"));
				adVo.setZipcode(rs.getString("zipcode"));
				adVo.setSido(rs.getString("sido"));
				adVo.setGugun(rs.getString("gugun"));
				adVo.setDong(rs.getString("dong"));
				adVo.setRi(rs.getString("ri"));
				adVo.setBldg(rs.getString("bldg"));
				adVo.setBunji(rs.getString("bunji"));
				address.add(adVo);
			}
			
			return address;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}
	
	//----------------------------------------------------------------
	//							회원 목록
	//----------------------------------------------------------------
	@Override
	public ArrayList<HotelMemberVo> memberList() throws Exception {
		conn = ds.getConnection();
		ArrayList<HotelMemberVo> members = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM HOTELMEMBER");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				members.add(new HotelMemberVo().setNo(rs.getInt("no"))
											   .setName(rs.getString("name"))
											   .setEmail(rs.getString("email"))
											   .setPw(rs.getString("pw"))
											   .setPhone(rs.getString("phone"))
											   .setZip_num(rs.getString("zip_num"))
											   .setAddress1(rs.getString("address1"))
											   .setAddress2(rs.getString("address2"))
											   .setUseyn(rs.getString("useyn"))
											   .setIndate(rs.getTimestamp("indate")));

			}
			return members;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}

	//----------------------------------------------------------------
	//							회원 정보 확인
	//----------------------------------------------------------------
	@Override
	public HotelMemberVo exist(String email, String pw, String useyn) throws Exception {
		conn = ds.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement("SELECT * FROM HOTELMEMBER WHERE EMAIL=? AND PW=? AND USEYN LIKE '%"+ useyn +"%'");
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				HotelMemberVo memberVo = new HotelMemberVo().setNo(rs.getInt("no"))
															.setName(rs.getString("name"))
															.setEmail(rs.getString("email"))
															.setPw(rs.getString("pw"))
															.setPhone(rs.getString("phone"))
														    .setZip_num(rs.getString("zip_num"))
														    .setAddress1(rs.getString("address1"))
														    .setAddress2(rs.getString("address2"))
														    .setUseyn(rs.getString("useyn"))
														    .setIndate(rs.getTimestamp("indate"));
				return memberVo;
			}
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return null;
	}	
	
	//----------------------------------------------------------------
	//						   회원 이메일 찾기
	//----------------------------------------------------------------
	@Override
	public HotelMemberVo findEmail(String name, String phone) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT EMAIL FROM HOTELMEMBER WHERE NAME =? AND PHONE =?");
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				HotelMemberVo memberVo = new HotelMemberVo().setEmail(rs.getString("email"));
				
				return memberVo;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//						   회원 비밀번호 찾기
	//----------------------------------------------------------------
	@Override
	public HotelMemberVo findPw(String email, String phone) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT PW FROM HOTELMEMBER WHERE EMAIL =? AND PHONE =?");
			pstmt.setString(1, email);
			pstmt.setString(2, phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				HotelMemberVo memberVo = new HotelMemberVo().setPw(rs.getString("pw"));
				
				return memberVo;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return null;
	}

	//----------------------------------------------------------------
	//						   회원 비밀번호 확인
	//----------------------------------------------------------------
	@Override
	public HotelMemberVo checkPw(String pw) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM HOTELMEMBER WHERE PW =?");
			pstmt.setString(1, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				HotelMemberVo memberVo = new HotelMemberVo().setNo(rs.getInt("no"))
															.setName(rs.getString("name"))
															.setEmail(rs.getString("email"))
															.setPw(rs.getString("pw"))
															.setPhone(rs.getString("phone"))
														    .setZip_num(rs.getString("zip_num"))
														    .setAddress1(rs.getString("address1"))
														    .setAddress2(rs.getString("address2"))
														    .setUseyn(rs.getString("useyn"))
														    .setIndate(rs.getTimestamp("indate"));
				return memberVo;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return null;
	}
	
	//----------------------------------------------------------------
	//							회원 선택
	//----------------------------------------------------------------
	@Override
	public HotelMemberVo selectOne(int no) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM HOTELMEMBER WHERE NO=? ");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new HotelMemberVo().setNo(rs.getInt("no"))
										.setName(rs.getString("name"))						
										.setEmail(rs.getString("email"))
										.setPw(rs.getString("pw"))
										.setPhone(rs.getString("phone"))
									    .setZip_num(rs.getString("zip_num"))
									    .setAddress1(rs.getString("address1"))
									    .setAddress2(rs.getString("address2"))
									    .setUseyn(rs.getString("useyn"))
									    .setIndate(rs.getTimestamp("indate"));
			}
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return null;
	}

	//----------------------------------------------------------------
	//						회원 정보 업데이트
	//----------------------------------------------------------------
	@Override
	public int update(HotelMemberVo hotelMemberVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE HOTELMEMBER SET EMAIL=?, PW=?, PHONE=?, ZIP_NUM=?, ADDRESS1=?, ADDRESS2=? WHERE NO=?");
			pstmt.setString(1, hotelMemberVo.getEmail());
			pstmt.setString(2, hotelMemberVo.getPw());
			pstmt.setString(3, hotelMemberVo.getPhone());
			pstmt.setString(4, hotelMemberVo.getZip_num());
			pstmt.setString(5, hotelMemberVo.getAddress1());
			pstmt.setString(6, hotelMemberVo.getAddress2());
			pstmt.setInt(7, hotelMemberVo.getNo());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}
	
	//----------------------------------------------------------------
	//							회원 탈퇴
	//----------------------------------------------------------------
	@Override
	public int useynUpdate(HotelMemberVo hotelMemberVo) throws Exception {
		conn = ds.getConnection();
		
		try {
			pstmt = conn.prepareStatement("UPDATE HOTELMEMBER SET USEYN='n' WHERE NO=?");
			pstmt.setInt(1, hotelMemberVo.getNo());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}

	//----------------------------------------------------------------
	//						회원 삭제
	//----------------------------------------------------------------
	@Override
	public int delete(String email) throws Exception {
		conn = ds.getConnection();

		try {
			pstmt = conn.prepareStatement("DELETE FROM HOTELMEMBER WHERE EMAIL=?");
			pstmt.setString(1, email);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return 0;

	}
	
}
