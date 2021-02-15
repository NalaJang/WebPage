package adminController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelMemberDao;
import hotelDto.HotelMemberVo;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/memberList.do")
public class MemberListController implements Controller{

	private HotelMemberDao memberDao;
	public MemberListController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		

		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			
			return "/hotel/login.jsp";
		} else {
			
			ArrayList<HotelMemberVo> memberList = memberDao.memberList();
			model.put("memberList", memberList);
			
			return "/hotel/adminMemberList.jsp";
		}
	}

}
