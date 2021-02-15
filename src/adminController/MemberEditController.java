package adminController;

import java.util.Map;

import hotelDao.HotelMemberDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/memberEdit.do")
public class MemberEditController implements Controller, DataBinding{

	private HotelMemberDao memberDao;
	public MemberEditController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HotelMemberVo memberVo = (HotelMemberVo)model.get("memberVo");
		int no = (Integer)model.get("no");
		
		if(memberVo.getEmail() == null) {
			HotelMemberVo memberInfo = memberDao.selectOne(no);
			model.put("memberInfo", memberInfo);
			
			return "/hotel/adminMemberEdit.jsp";
		} else {

			memberDao.update(memberVo);
			
			return "redirect:../hotel/memberList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"memberVo" , HotelMemberVo.class, "no", Integer.class};
	}

}
