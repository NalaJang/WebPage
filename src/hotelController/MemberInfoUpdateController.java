package hotelController;

import java.util.Map;

import hotelDao.HotelMemberDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberInfoUpdate.do")
public class MemberInfoUpdateController implements Controller, DataBinding {

	private HotelMemberDao memberDao;
	public MemberInfoUpdateController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

//		HttpSession session = (HttpSession)model.get("session");
//		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		HotelMemberVo memberVo = (HotelMemberVo)model.get("memberVo");
		
		int no = (Integer)model.get("no");
		
		if(memberVo.getEmail() == null) {
			HotelMemberVo memberInfo = memberDao.selectOne(no);
			model.put("memberInfo", memberInfo);
			
			return "/hotel/memberInfoUpdate.jsp";
		} else {

			memberDao.update(memberVo);
			
			return "redirect:../hotel/main.do";
		}
		
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"no", Integer.class, "memberVo", HotelMemberVo.class};
	}
}
