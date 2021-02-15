package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelMemberDao;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberDelete.do")
public class MemberDeleteController implements Controller, DataBinding{

	private HotelMemberDao memberDao;
	public MemberDeleteController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo worker = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(worker == null) {
			
			return "/hotel/login.jsp";
		} else {
			String email = (String)model.get("email");
			
			memberDao.delete(email);
			return "redirect:../hotel/memberList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
	
		return new Object[] {"email", String.class};
	}

}
