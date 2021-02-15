package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/campaignReviewForm.do")
public class CampaignReviewInsertForm implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			
			return "/hotel/campaignReviewInsert.jsp";
		}
	}

}
