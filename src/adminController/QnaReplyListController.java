package adminController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelQnADao;
import hotelDto.HotelMemberVo;
import hotelDto.HotelQnAVo;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotle/qnaReplyList.co")
public class QnaReplyListController implements Controller{

	private HotelQnADao qnaDao;
	public QnaReplyListController setQnaDao(HotelQnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(memberVo == null || workerVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			HotelQnAVo qnaVo = (HotelQnAVo)model.get("qnaVo");
			ArrayList<HotelQnAVo> replyList = qnaDao.qnaReplyList(qnaVo);
			
			model.put("replyList", replyList);
			
			return "/hotel//hotel/qnaContent.do?";
		}
	}

}
