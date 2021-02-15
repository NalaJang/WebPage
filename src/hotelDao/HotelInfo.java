package hotelDao;

import java.util.ArrayList;

import hotelDto.AddressVo;
import hotelDto.HotelMemberVo;

public interface HotelInfo {
	int insert(HotelMemberVo hotelMemberVo) throws Exception;					//회원가입
	ArrayList<AddressVo> address(String dong) throws Exception;					//주소찾기
	ArrayList<HotelMemberVo> memberList() throws Exception;						//회원목록
	HotelMemberVo exist(String email, String pw, String useyn) throws Exception;//회원확인
	HotelMemberVo findEmail(String name, String phone) throws Exception;		//이메일찾기
	HotelMemberVo findPw(String email, String phone) throws Exception;			//비밀번호찾기
	HotelMemberVo checkPw(String pw) throws Exception;							//비밀번호확인
	HotelMemberVo selectOne(int no) throws Exception;							//회원선택
	int update(HotelMemberVo hotelMemberVo) throws Exception;					//정보수정
	int useynUpdate(HotelMemberVo hotelMemberVo) throws Exception;				//회원탈퇴
	int delete(String email) throws Exception;									//회원삭제
	
	
}
