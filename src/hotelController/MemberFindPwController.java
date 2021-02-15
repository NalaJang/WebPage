package hotelController;

import java.util.Map;

import hotelDao.HotelMemberDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberFindPw.do")
public class MemberFindPwController implements Controller, DataBinding{
	
	private HotelMemberDao memberDao;
	
	public MemberFindPwController setMemberDao(HotelMemberDao memberDao) {		
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String email = (String)model.get("email");
		String phone = (String)model.get("phone");
		
		if(memberDao.findPw(email, phone) != null) {
			
			model.put("findPw", memberDao.findPw(email, phone));
			
			return "/hotel/memberFindPwAfter.jsp";
		} else {
			
			return "/hotel/memberFindPw.jsp";
		}

	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {"email", String.class, "phone", String.class};
	}
}
