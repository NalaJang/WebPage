package adminController;

import java.util.Map;

import hotelDao.HotelMemberDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberEditForm.do")
public class MemberEditForm implements Controller, DataBinding{

	private HotelMemberDao memberDao;
	public MemberEditForm setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int no = (Integer)model.get("no");
		
		model.put("memberInfo", memberDao.selectOne(no));
		
		return "/hotel/adminMemberEdit.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"no", Integer.class};
	}

}
