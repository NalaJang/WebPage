package hotelController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelQnADao;
import hotelDto.HotelMemberVo;
import hotelDto.HotelQnAVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/qnaList.do")
public class QnAListController implements Controller {

	private HotelQnADao qnaDao;
	public QnAListController setQnaDao(HotelQnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			
			ArrayList<HotelQnAVo> qnaList = qnaDao.qnaList(memberVo.getEmail());
			model.put("qnaList", qnaList);
			
			return "/hotel/qnaList.jsp";
		}
	}

}
