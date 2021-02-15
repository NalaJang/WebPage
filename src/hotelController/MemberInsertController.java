package hotelController;

import java.util.Map;

import hotelDao.HotelMemberDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberInsert.do")
public class MemberInsertController implements Controller, DataBinding {

	private HotelMemberDao memberDao;
	public MemberInsertController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HotelMemberVo memberVo = (HotelMemberVo)model.get("memberVo");
		memberDao.insert(memberVo);
		
		return "/hotel/main.jsp";
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"memberVo", HotelMemberVo.class};
	}

}
