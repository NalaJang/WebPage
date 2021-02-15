package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelMemberDao;
import hotelDao.HotelWorkerDao;
import hotelDto.HotelMemberVo;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/login.do")
public class LoginController implements Controller, DataBinding{
	
	private HotelMemberDao memberDao;
	private HotelWorkerDao workerDao;
	
	public LoginController setMemberDao(HotelMemberDao memberDao) {		
		this.memberDao = memberDao;
		return this;
	}
	public LoginController setWorkerDao(HotelWorkerDao workerDao) {
		this.workerDao = workerDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"loginInfo", hotelDto.HotelMemberVo.class, "loginInfo2", hotelDto.HotelWorkerVo.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		if(model.get("loginInfo") == null || model.get("loginInfo2") == null) {
			return "/hotel/login.jsp";
		} else {
			
			HotelMemberVo loginInfo = (HotelMemberVo)model.get("loginInfo");	//회원
			HotelWorkerVo loginInfo2 = (HotelWorkerVo)model.get("loginInfo2");	//관리자
			
			HotelMemberVo hotelMember = memberDao.exist(loginInfo.getEmail(), loginInfo.getPw(), "y");	//회원상태(useyn)이 'y'인 경우만 로그인 성공
			HotelWorkerVo hotelWorker = workerDao.exist(loginInfo2.getEmail(), loginInfo2.getPw());
			
			if(hotelMember != null || hotelWorker != null ) {
				HttpSession session = (HttpSession)model.get("session");
				
				session.setAttribute("hotelMember", hotelMember);
				session.setAttribute("hotelWorker", hotelWorker);
				
				return "redirect:../hotel/main.do";
			} else {
				return "/hotel/loginFail.jsp";
				
			}
		}
	}

}
