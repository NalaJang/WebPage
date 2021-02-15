package hotelController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelQnADao;
import hotelDto.HotelMemberVo;
import hotelDto.HotelQnAVo;
import hotelDto.HotelWorkerVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/qnaContent.do")
public class QnAContentController implements Controller, DataBinding {

	private HotelQnADao qnaDao;
	public QnAContentController setQnaDao(HotelQnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(memberVo != null || workerVo != null) {
			int qseq = (Integer)model.get("qseq");
			
			HotelQnAVo qnaVo = (HotelQnAVo)model.get("qnaVo");
			ArrayList<HotelQnAVo> replyList = qnaDao.qnaReplyList(qnaVo);
			
			model.put("qnaVo", qnaDao.getqna(qseq));	//문의관련

			model.put("replyList", replyList);			//답변목록
			
			return "/hotel/qnaContent.jsp";
			
		} else {
			return "/hotel/login.jsp";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"qseq", Integer.class, "qnaVo", HotelQnAVo.class};
	}

}
