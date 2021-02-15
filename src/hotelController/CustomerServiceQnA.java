package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/customerServiceQnA.do")
public class CustomerServiceQnA implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			
			return "/hotel/login.jsp";
		} else {
			
			return "/hotel/qnaInsert.jsp";
		}
	}

}
