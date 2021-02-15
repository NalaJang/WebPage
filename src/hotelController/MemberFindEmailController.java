package hotelController;

import java.util.Map;

import hotelDao.HotelMemberDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberFindEmail.do")
public class MemberFindEmailController implements Controller, DataBinding{
	
	private HotelMemberDao memberDao;
	
	public MemberFindEmailController setMemberDao(HotelMemberDao memberDao) {		
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String name = (String)model.get("name");
		String phone = (String)model.get("phone");
		
		if(memberDao.findEmail(name, phone) != null) {
			
			model.put("findEmail", memberDao.findEmail(name, phone));
			
			return "/hotel/memberFindEmailAfter.jsp";
		} else {
			
			return "/hotel/memberFindEmail.jsp";
		}

	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {"name", String.class, "phone", String.class};
	}
}
