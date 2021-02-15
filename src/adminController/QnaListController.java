package adminController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelQnADao;
import hotelDto.HotelQnAVo;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/qnaListAll.do")
public class QnaListController implements Controller{

	private HotelQnADao qnaDao;
	public QnaListController setQnADao(HotelQnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			
			return "redirect:../hotel/logout.do";
			
		} else {
			ArrayList<HotelQnAVo> qnaList = qnaDao.qnaListAll();
			model.put("qnaList", qnaList);
			
			return "/hotel/adminQnaList.jsp";
		}
	}

}
