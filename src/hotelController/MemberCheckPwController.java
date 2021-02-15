package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelMemberDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/checkPw.do")
public class MemberCheckPwController implements Controller, DataBinding{

	private HotelMemberDao memberDao;
	public MemberCheckPwController setMemberDao(HotelMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		String pw = (String)model.get("pw");
		
		if(!memberVo.getPw().equals(pw)) {

			return "/hotel/memberCheckPw.jsp";
		} else {

			memberDao.checkPw(memberVo.getPw());
			model.put("memberVo", memberVo);
			
//			return "/hotel/memberInfoUpdate.jsp";	//컨트롤을 거쳐서 가야 수정된 정보를 바로 볼 수 있다.
			
			return "redirect:../hotel/memberInfoUpdate.do?no="+memberVo.getNo();
//			return "redirect:../hotel/memberInfoUpdate.do?no=3";
			
		}
	}

	@Override
	public Object[] getDataBinders() {
	
		return new Object[] {"pw", String.class};
	}

}
