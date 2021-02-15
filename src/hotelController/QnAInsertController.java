package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelQnADao;
import hotelDto.HotelMemberVo;
import hotelDto.HotelQnAVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/qnaInsert.do")
public class QnAInsertController implements Controller, DataBinding{

	private HotelQnADao qnaDao;
	public QnAInsertController setQnaDao(HotelQnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
//		HotelMemberVo memberVo = (HotelMemberVo)model.get("memberVo");
		
		if(memberVo == null) {
			
			return "/hotel/login.jsp";
			
		} else {
			
			HotelQnAVo qnaVo = (HotelQnAVo)model.get("qnaVo");
			qnaDao.insertqna(qnaVo, memberVo.getEmail());
			
			return "redirect:../hotel/qnaList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qnaVo", HotelQnAVo.class};
	}

}
