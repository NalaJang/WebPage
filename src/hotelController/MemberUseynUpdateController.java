package hotelController;

import java.util.Map;

import hotelDao.HotelMemberDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberUseynUpdate.do")
public class MemberUseynUpdateController implements Controller, DataBinding{

	private HotelMemberDao memberDao;
	public MemberUseynUpdateController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HotelMemberVo memberVo = (HotelMemberVo)model.get("memberVo");
		
		if(memberVo.getEmail() == null) {
			
			int no = (Integer)model.get("no");
			HotelMemberVo memberInfo = memberDao.selectOne(no);
			model.put("memberInfo", memberInfo);
			
			return "/hotel/memberInfoUpdate.jsp";
		} else {			
			
			memberDao.useynUpdate(memberVo);
			
			return "redirect:../hotel/logout.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"memberVo", HotelMemberVo.class, "no", Integer.class};
	}
}
